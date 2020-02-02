package com.zhangkai.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangkai.dto.UserDto;
import com.zhangkai.entity.THouse;
import com.zhangkai.entity.TStudent;
import com.zhangkai.service.StudentService;
import com.zhangkai.util.JsonMananger;
import com.zhangkai.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 张凯 on 2020/1/31.
 */
@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;



    @RequestMapping("getStudentList")
    public ResultEntity selectObject(@RequestBody UserDto userDto) {
        System.out.println("---------------->"+userDto);
        System.out.println("------->"+userDto.getPageNo()+"------------>"+userDto.getPageSize());


//        PageHelper.startPage(userDto.getPageNo(),userDto.getPageSize());
        PageHelper.startPage(userDto.getPageNo(),userDto.getPageSize());
        Wrapper<TStudent> wrapper = new EntityWrapper<TStudent>();
        List<TStudent> users = studentService.selectObject(userDto);
        PageInfo pageInfo = new PageInfo(users);
        return ResultEntity.ok(pageInfo);
    }


    /**
     * 添加学生
     * @param userDto
     */
    @RequestMapping("addStudent")
    public ResultEntity addStudent(@RequestBody UserDto userDto){

        System.out.println("----添加---->"+userDto);
        TStudent tStudent = new TStudent();

        tStudent.setName(userDto.getName());
        tStudent.setStuNo(userDto.getStuNo());
        studentService.addStudent(tStudent);

        System.err.println("------添加学生ID------->"+tStudent.getId());
        System.err.println("------添加学生ID------->"+userDto.getId());

        String courseNames = userDto.getCourseNames();
        System.out.println("-------String kecheng--------->"+courseNames);
        System.out.println("------courseNames------>"+courseNames);

        List<THouse> tHouses = JsonMananger.jsonToList(courseNames, THouse.class);

        for (THouse tHouse : tHouses) {
            System.out.println("---THouse-->"+tHouse);
            THouse house = new THouse();
            house.setStuId(tStudent.getId());
            house.setCourseName(tHouse.getCourseName());
            house.setFraction(tHouse.getFraction());
            System.out.println("------house------->"+house);
            studentService.addTHouse(house);
        }

        return ResultEntity.ok();
    }

    /**
     * 修改学生
     * @param userDto
     */
    @RequestMapping("updateStudent")
    public ResultEntity updateStudent(@RequestBody UserDto userDto){
        System.out.println("----修改---->"+userDto);
        TStudent tStudent = new TStudent();
        tStudent.setId(userDto.getId());
        tStudent.setName(userDto.getName());
        tStudent.setStuNo(userDto.getStuNo());
        System.out.println("----修改的学生信息----->"+tStudent);
        studentService.updateStudent(tStudent);

        String courseNames = userDto.getCourseNames();
        System.out.println("-------String kecheng--------->"+courseNames);
        System.out.println("------courseNames------>"+courseNames);

        List<THouse> tHouses = JsonMananger.jsonToList(courseNames, THouse.class);

        for (THouse tHouse : tHouses) {
            System.out.println("---THouse-->"+tHouse);
            if (tHouse.getId()==null){
                THouse house = new THouse();
                house.setStuId(tStudent.getId());
                house.setCourseName(tHouse.getCourseName());
                house.setFraction(tHouse.getFraction());
                System.out.println("------house------->"+house);
                studentService.addTHouse(house);
            }else{
                System.err.println("---已有的成绩--->"+tHouse);
            }

        }

        return ResultEntity.ok();
    }


    /**
     * 根据ID删除学生
     * @param id
     */
    @RequestMapping("deleteStudentById")
    public ResultEntity deleteStudentById(@RequestBody Integer id){
        System.out.println("------删除学生表------>"+id);
        studentService.deleteStudentById(id);
        //根据ID删除课程表
        studentService.deleteById(id);
        return ResultEntity.ok();
    }


    /**
     * 根据成绩单ID删除
     * @param id
     * @return
     */
    @RequestMapping("deleteHouseById")
    public ResultEntity deleteHouseById(@RequestBody Integer id){
        studentService.deleteHouseById(id);
        return ResultEntity.ok();
    }



    /**
     * 根据学生ID 查询  对应的成绩单
     * @param id
     * @return
     */
    @RequestMapping("selectTHouseById")
    public ResultEntity selectTHouseById(@RequestBody Integer id){
        System.out.println("-----单查---->"+id);
        List<THouse> tHouses = studentService.selectTHouseById(id);
        return ResultEntity.ok(tHouses);
    }

    /**
     * 根据学生ID查询
     * @param id
     * @return
     */
    @RequestMapping("selectStudentById")
    public ResultEntity selectStudentById(@RequestBody Integer id){
        TStudent tStudent = studentService.selectStudentById(id);
        return ResultEntity.ok(tStudent);
    }

}
