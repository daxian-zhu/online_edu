package com.clark.online_edu.customer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import com.clark.online_edu.config.ResServerConfig;

/**
 * 资源服务配置
 * @ EnableResourceServer 启用资源服务
 * @ EnableWebSecurity 启用web安全
 * @ EnableGlobalMethodSecurity 启用全局方法安全注解，就可以在方法上使用注解来对请求进行过滤
 */
@Configuration
public class ResourceServerConfig extends ResServerConfig{
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	super.configure(http);
    	http
    		//拦截所有请求,下面2种写法都行
    		.authorizeRequests().antMatchers("/**").authenticated();
//    		.and().authorizeRequests().anyRequest().authenticated();
    }
    
}