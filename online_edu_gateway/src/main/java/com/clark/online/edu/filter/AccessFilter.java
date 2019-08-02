package com.clark.online.edu.filter;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.util.Result;

import reactor.core.publisher.Mono;

/**
 * 资源过滤器 所有的资源请求在路由之前进行前置过滤 如果请求头不包含 Authorization参数值，直接拦截不再路由
 * 
 * @author 大仙
 *
 */
@Component
public class AccessFilter implements GlobalFilter {

	private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();

		logger.info("send {} request to {}", request.getMethod(), request.getURI().toString());
		// 获取请求头
		Object accessToken = request.getHeaders().get("Authorization");
		if (accessToken == null) {
			// 没有Authoriztion返回401
			ServerHttpResponse response = exchange.getResponse();
			logger.warn("Authorization token is empty");
			byte[] datas = JSON.toJSONString(Result.failure(ResponeCode.FAIL_401)).getBytes(StandardCharsets.UTF_8);
		    DataBuffer buffer = response.bufferFactory().wrap(datas);
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
	        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
	        return response.writeWith(Mono.just(buffer));
		}
		
		logger.info("Authorization token is ok");
		return chain.filter(exchange);
	}

}
