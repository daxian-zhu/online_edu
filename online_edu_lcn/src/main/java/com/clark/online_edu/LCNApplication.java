package com.clark.online_edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;

@SpringBootApplication
@EnableTransactionManagerServer
public class LCNApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(LCNApplication.class, args);
	}

}
