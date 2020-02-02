package com.zhangkai.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class MyFilter extends AbstractGatewayFilterFactory {

    public static final String begin_time = "beginTime";

    @Override
    public GatewayFilter apply(Object config) {
        return (ServerWebExchange exchange, GatewayFilterChain chain)->{
            long l = System.currentTimeMillis();
            exchange.getAttributes().put(begin_time,l);
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                long bt = exchange.getAttribute(begin_time);
                log.info("响应时间为：{}毫秒",System.currentTimeMillis()-bt);
            }));

        };
    }
}
