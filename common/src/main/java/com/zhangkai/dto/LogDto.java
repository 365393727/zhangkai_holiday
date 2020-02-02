package com.zhangkai.dto;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(value = "log")
public class LogDto extends Page {

    private String ip;

    private String port;

    private String desc;

    private String method;

    private String url;

    private String classname;

    private Object[] args;

    private Date createTime;


    private String username;
}
