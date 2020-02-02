package com.zhangkai.sevice;


import com.alibaba.fastjson.JSON;
import com.zhangkai.dto.LogDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class LogService {


    @Autowired
    MongoTemplate mongoTemplate;
    public Map<String,Object> findLogPage(LogDto logDto){
        Query query = new Query();
        if (StringUtils.isNotBlank(logDto.getIp())){
            query.addCriteria(Criteria.where("ip").is(logDto.getIp()));
        }
        long count = mongoTemplate.count(query, LogDto.class);
        query.skip((logDto.getPageNo()-1)*logDto.getPageSize());
        query.limit(logDto.getPageSize());
        List<LogDto> logDtos = mongoTemplate.find(query, LogDto.class);

        Map<String,Object> map = new HashMap<String,Object>(){{
            put("cout",count);
            put("list",logDtos);
        }};

        log.info(JSON.toJSONString(map));
        return map;
    }


    public void  save(LogDto logDto){
        mongoTemplate.save(logDto);
    }
}
