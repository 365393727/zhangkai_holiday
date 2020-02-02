package com.zhangkai.dto;


import lombok.Data;

@Data
public class RoleDTO extends  Page {


    private Integer id;

    private String name;

    /**
     * 角色名称
     */
    private String nameZh;
}
