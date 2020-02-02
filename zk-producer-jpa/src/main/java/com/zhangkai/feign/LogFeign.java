package com.zhangkai.feign;


import com.zhangkai.dto.LogDto;
import com.zhangkai.vo.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "mongodb")
public interface LogFeign {


    @RequestMapping(value = "/log/add",method = RequestMethod.POST)
    public ResultEntity add(LogDto logDto);
}
