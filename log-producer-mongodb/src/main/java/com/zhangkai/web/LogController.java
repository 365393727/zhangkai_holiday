package com.zhangkai.web;


import com.zhangkai.dto.LogDto;
import com.zhangkai.vo.ResultEntity;
import com.zhangkai.sevice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/find/log/page",method = RequestMethod.GET)
    public ResultEntity findLogPage(LogDto logDto){
        Map<String, Object> logPage = logService.findLogPage(logDto);
        return ResultEntity.ok(logPage);
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultEntity add(@RequestBody LogDto logDto){
        logService.save(logDto);
        return ResultEntity.ok();
    }
}
