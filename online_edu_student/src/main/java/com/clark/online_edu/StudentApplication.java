package com.clark.online_edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.clark.online_edu.annotation.EnableResJWTTokenStore;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableResJWTTokenStore //OAuth2 使用 JWT 解析令牌
//开启分布式事务
@EnableDistributedTransaction
public class StudentApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StudentApplication.class, args);
	}

}
