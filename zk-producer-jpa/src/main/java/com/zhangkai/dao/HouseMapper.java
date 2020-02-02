package com.zhangkai.dao;

import com.zhangkai.entity.THouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 张凯 on 2020/2/1.
 */
@Mapper
public interface HouseMapper {

    /**
     * 添加课程
     * @param tHouse
     */
    void addTHouse(THouse tHouse);

    /**
     * 删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据学生ID 查询  对应的成绩单
     * @param id
     * @return
     */
    List<THouse> selectTHouseById(Integer id);

    /**
     * 根据成绩单ID删除
     * @param id
     * @return
     */
    void deleteHouseById(Integer id);
}
