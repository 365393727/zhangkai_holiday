package com.zhangkai.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
public class UserDto extends  Page {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学号
     */
    private String stuNo;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程分数
     */
    private Integer fraction;

    /**
     * 学生ID
     */
    private Integer stuId;

    /**
     * 语文
     */
    private String yuwen;

    /**
     * 数学
     */
    private String shuxue;

    /**
     * 英语
     */
    private String yingyu;

    /**
     * 物理
     */
    private String wuli;

    /**
     * 化学
     */
    private String huaxue;

    /**
     * 生物
     */
    private String shengwu;

    /**
     * 总成绩
     */
    private String sumtoble;

    /**
     * SSH
     */
    private String ssh;

    /**
     * SSM
     */
    private String ssm;

    /**
     * jave
     */
    private String ja;

    /**
     * 添加课程名称集合
     */
    private String courseNames;









    private Integer[] value;

    private String[] images;

    private String zhengCard;

    private String fanCard;
    private String code;

    /**
     * 头像图片
     */
    private MultipartFile files;

    /**
     * 正面身份证图片
     */
    private MultipartFile zhengCards;

    /**
     * 反面身份证图片
     */
    private MultipartFile fanCards;



}
