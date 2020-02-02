package com.zhangkai.service;

import com.zhangkai.dao.HouseMapper;
import com.zhangkai.dao.StudentMapper;
import com.zhangkai.dto.UserDto;
import com.zhangkai.entity.THouse;
import com.zhangkai.entity.TStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张凯 on 2020/1/31.
 */
@Service
public class StudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Autowired(required = false)
    private HouseMapper houseMapper;


    /**
     * 全查
     * @return
     */
    public List<TStudent> selectObject(UserDto userDto){

        return  studentMapper.selectObject(userDto);
    }


    /**
     * 添加学生
     * @param tStudent
     */
    public void addStudent(TStudent tStudent){
        studentMapper.addStudent(tStudent);
    }

    /**
     * 修改学生
     * @param tStudent
     */
    public void updateStudent(TStudent tStudent){
        studentMapper.updateStudent(tStudent);
    }
    /**
     * 添加课程
     * @param tHouse
     */
    public void addTHouse(THouse tHouse){
        houseMapper.addTHouse(tHouse);
    }

    /**
     * 根据ID删除学生
     * @param id
     */
    public void deleteStudentById(Integer id){
        studentMapper.deleteStudentById(id);
    }

    /**
     * 根据ID删除课程表
     * @param id
     */
    public void deleteById(Integer id){
        houseMapper.deleteById(id);
    }

    /**
     * 根据成绩单ID删除
     * @param id
     * @return
     */
    public void deleteHouseById(Integer id){
        houseMapper.deleteHouseById(id);
    }

    /**
     * 根据学生ID 查询  对应的成绩单
     * @param id
     * @return
     */
    public List<THouse> selectTHouseById(Integer id){
        System.out.println("-----根据学生ID 查询  对应的成绩单---->"+id);

        return houseMapper.selectTHouseById(id);
    }

    /**
     * 根据学生ID查询
     * @param id
     * @return
     */
    public TStudent selectStudentById(Integer id){
        return studentMapper.selectStudentById(id);
    }

}
