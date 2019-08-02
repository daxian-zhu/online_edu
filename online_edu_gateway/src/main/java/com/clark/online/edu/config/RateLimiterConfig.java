//package com.clark.online.edu.config;
//
//import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import reactor.core.publisher.Mono;
//
///**
// * 限流配置
// * 
// * @author 大仙
// *
// */
//@Configuration
//public class RateLimiterConfig {
//	
//	@Bean(value = "remoteAddKeyResolver")
//	public KeyResolver remoteAddKeyResolver() {
//		//new Thread( () -> System.out.println("In Java8, There is Lambda expression!") ).start();
//		//                       new 一个实现匿名实现((方法参数)->{方法实现})
////		KeyResolver keyResolver = (exchange)-> {return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());} ;
////		//如果方法只有一个参数，可以省略括号
////		keyResolver =exchange-> {return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());} ;
//		//如果实现只有一个表达式的时候可以省略大括号，和return，类似if判断
////		keyResolver =exchange-> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress()) ;
//		return exchange-> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
//			
//		
//	}
//}
