package com.clark.online.edu.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import com.clark.online_edu.config.ResServerConfig;

/**
 * 资源服务器配置
 * 
 * @param resources
 * @throws Exception
 */
@Configuration
public class ResourceServerConfig extends ResServerConfig{
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	super.configure(http);
    	   http.csrf().disable().exceptionHandling()
           .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
           .and()
           .authorizeRequests()
           .anyRequest().authenticated()
           .and()
           .httpBasic();

    }
    
}

