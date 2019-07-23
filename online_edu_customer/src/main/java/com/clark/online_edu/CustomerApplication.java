package com.clark.online_edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.clark.online_edu.annotation.EnableResJWTTokenStore;
/**
 * 启动类
 * @author 大仙
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableResJWTTokenStore //OAuth2 使用 JWT 解析令牌
public class CustomerApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
