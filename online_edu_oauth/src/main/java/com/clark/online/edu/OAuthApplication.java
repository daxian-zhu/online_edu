package com.clark.online.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.clark.online_edu.annotation.EnableAuthJWTTokenStore;
import com.clark.online_edu.annotation.EnableDBClientDetailsService;
import com.clark.online_edu.annotation.EnableResJWTTokenStore;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableDBClientDetailsService //从 JDBC 加载客户端详情,需配置在启动类上，若在子类上会出现顺序问题，导致 Bean 创建失败
@EnableResJWTTokenStore //OAuth2 使用 JWT 解析令牌
@EnableAuthJWTTokenStore    // 使用 JWT 存储令牌
public class OAuthApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(OAuthApplication.class, args);
	}
	
}
