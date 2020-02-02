package com.zhangkai.aop;


import com.alibaba.fastjson.JSON;
import com.zhangkai.dto.LogDto;
import com.zhangkai.vo.ResultEntity;
import com.zhangkai.annotations.Log;
import com.zhangkai.feign.LogFeign;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
public class LogAop {

    @Pointcut("execution(* com.zhangkai.controller.*.*(..))")
    public void  pointcut(){}


    @Autowired
    LogFeign logFeign;
    @AfterReturning(value = "pointcut()")
    public void after(JoinPoint joinPoint){

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Log annotation = method.getAnnotation(Log.class);
        if (annotation!=null){
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();

            LogDto logDto = new LogDto();
            logDto.setUrl(request.getRequestURI());
            logDto.setIp(request.getRemoteAddr());
            logDto.setPort(request.getServerPort()+"");
            logDto.setMethod(request.getMethod());
            logDto.setDesc(annotation.value());
            logDto.setArgs(joinPoint.getArgs());
            logDto.setUsername(request.getSession().getAttribute("user")==null?"":request.getSession().getAttribute("user").toString());

            ResultEntity add = logFeign.add(logDto);
            log.info("aop 添加日志返回结果为:{}", JSON.toJSONString(add));

        }

    }

}
