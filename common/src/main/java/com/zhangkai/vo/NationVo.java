package com.zhangkai.vo;


import lombok.Data;

import java.util.List;

@Data
public class NationVo {

    private int value;

    private String label;


    private List<NationVo> children;
}
