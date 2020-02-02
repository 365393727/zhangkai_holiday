package com.zhangkai.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

//@Order(1)
//@Slf4j
//@Component
@AllArgsConstructor
public class MyGlobalFilter implements GlobalFilter {


    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isBlank(token)){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code","500");
            map.put("msg","操作失败");
            map.put("obj","token为空");
            try {
                return response.writeWith(Mono.just(response.bufferFactory()
                        .wrap(objectMapper.writeValueAsBytes(map))));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return chain.filter(exchange);
    }
}