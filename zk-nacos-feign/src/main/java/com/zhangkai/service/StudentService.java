package com.zhangkai.service;

import com.zhangkai.dto.UserDto;
import com.zhangkai.vo.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 张凯 on 2020/1/31.
 */
@FeignClient(value = "upms-producer")
public interface StudentService {


    @RequestMapping("/student/getStudentList")
    public ResultEntity selectObject(@RequestBody UserDto userDto);


    @RequestMapping("/student/addStudent")
    public ResultEntity addStudent(@RequestBody UserDto userDto);

    /**
     * 修改学生
     * @param userDto
     */
    @RequestMapping("/student/updateStudent")
    public ResultEntity updateStudent(@RequestBody UserDto userDto);

    /**
     * 根据ID删除学生
     * @param id
     */
    @RequestMapping("/student/deleteStudentById")
    public ResultEntity deleteStudentById(@RequestBody Integer id);

    /**
     * 根据成绩单ID删除
     * @param id
     * @return
     */
    @RequestMapping("/student/deleteHouseById")
    public ResultEntity deleteHouseById(@RequestBody Integer id);

    /**
     * 根据学生ID 查询  对应的成绩单
     * @param id
     * @return
     */
    @RequestMapping("/student/selectTHouseById")
    public ResultEntity selectTHouseById(@RequestBody Integer id);

    /**
     * 根据学生ID查询
     * @param id
     * @return
     */
    @RequestMapping("/student/selectStudentById")
    public ResultEntity selectStudentById(@RequestBody Integer id);

}
