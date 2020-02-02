package com.zhangkai.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable{


    private int pageNo;
    private int pageSize;
}
