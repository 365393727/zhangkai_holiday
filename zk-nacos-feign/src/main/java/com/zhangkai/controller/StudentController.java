package com.zhangkai.controller;

import com.zhangkai.dto.UserDto;
import com.zhangkai.service.StudentService;
import com.zhangkai.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张凯 on 2020/1/31.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired(required = false)
    private StudentService studentService;

    /**
     * 查询
     * @param userDto
     * @return
     */
    @RequestMapping("getStudentList")
    public ResultEntity selectObject(UserDto userDto) {
        ResultEntity resultEntity = studentService.selectObject(userDto);
        return resultEntity;
    }

    @RequestMapping("addStudent")
    public ResultEntity addStudent(@RequestBody UserDto userDto){
        System.out.println("-----addStudent-- feign--------->"+userDto);
        ResultEntity resultEntity = studentService.addStudent(userDto);

        return resultEntity;
    }


    @RequestMapping("updateStudent")
    public ResultEntity updateStudent(@RequestBody UserDto userDto){
        System.out.println("-----updateStudent-- feign--------->"+userDto);
        ResultEntity resultEntity = studentService.updateStudent(userDto);
        return resultEntity;
    }


    /**
     * 根据ID删除学生
     * @param id
     */
    @RequestMapping("deleteStudentById")
    public ResultEntity deleteStudentById(Integer id){
        System.out.println("-----addStudent-- feign--------->"+id);
        ResultEntity resultEntity = studentService.deleteStudentById(id);
        return resultEntity;
    }
    /**
     * 根据ID批量删除学生
     * @param ids
     */
    @RequestMapping("deleteStudentByIds")
    public ResultEntity deleteStudentByIds(Integer[] ids){
        System.out.println("-----addStudent-- feign--------->"+ids);
        ResultEntity resultEntity = null;
        for (Integer id : ids) {
            resultEntity = studentService.deleteStudentById(id);
        }
        return resultEntity;
    }

    /**
     * 根据成绩单ID删除
     * @param id
     * @return
     */
    @RequestMapping("deleteHouseById")
    public ResultEntity deleteHouseById(Integer id){
        System.out.println("-----deleteHouseById-- feign--------->"+id);
        ResultEntity resultEntity = studentService.deleteHouseById(id);
        return resultEntity;
    }

    /**
     * 根据学生ID 查询  对应的成绩单
     * @param id
     * @return
     */
    @RequestMapping("selectTHouseById")
    public ResultEntity selectTHouseById(Integer id){
        System.out.println("---id---->"+id);
        ResultEntity resultEntity = studentService.selectTHouseById(id);
        return resultEntity;
    }

    /**
     * 根据学生ID查询
     * @param id
     * @return
     */
    @RequestMapping("selectStudentById")
    public ResultEntity selectStudentById(Integer id){
        ResultEntity resultEntity = studentService.selectStudentById(id);
        return resultEntity;
    }
}
