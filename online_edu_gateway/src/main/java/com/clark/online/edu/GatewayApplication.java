package com.clark.online.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * 启动类
 * @author 大仙
 *
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
