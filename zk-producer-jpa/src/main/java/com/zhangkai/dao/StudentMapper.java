package com.zhangkai.dao;

import com.zhangkai.dto.UserDto;
import com.zhangkai.entity.THouse;
import com.zhangkai.entity.TStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 张凯 on 2020/1/31.
 */
@Mapper
public interface StudentMapper {

    /**
     * 全查
     * @return
     */
    List<TStudent> selectObject(UserDto userDto);

   // List<TStudent> findAll(@Param("page") Page<TStudent> page, @Param("userDto") UserDto userDto);

    /**
     * 添加学生
     * @param tStudent
     */
    void addStudent(TStudent tStudent);

    /**
     * 修改学生
     * @param tStudent
     */
    void updateStudent(TStudent tStudent);

    /**
     * 删除
     * @param id
     */
    void deleteStudentById(Integer id);

    /**
     * 根据学生ID查询
     * @param id
     * @return
     */
    TStudent selectStudentById(Integer id);

}
