package com.zhangkai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceGatewayFirstApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServiceGatewayFirstApplication.class, args);
	}


	@Bean
	public HostAddrKeyResolver hostAddrKeyResolver() {
		return new HostAddrKeyResolver();
	}

}


class HostAddrKeyResolver implements KeyResolver {

	@Override
	public Mono<String> resolve(ServerWebExchange exchange) {
		return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}

}