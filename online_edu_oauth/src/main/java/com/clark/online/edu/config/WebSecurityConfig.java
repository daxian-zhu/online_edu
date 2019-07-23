package com.clark.online.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import com.clark.online.edu.service.impl.UserDetailsServiceImpl;
import com.clark.online_edu.config.AbstractSecurityConfig;

/**
 * 配置spring security
 * ResourceServerConfig 是比SecurityConfig 的优先级低的
 * @author 大仙
 *
 */
@Configuration
public class WebSecurityConfig extends AbstractSecurityConfig {
	
	/**
	 * 用户详情业务实现
	 */
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	/**
	 * 重新实例化bean
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http    // 配置登陆页/login并允许访问
          .formLogin().permitAll()
          // 其余所有请求全部需要鉴权认证
          .and().authorizeRequests().anyRequest().authenticated()
          // 由于使用的是JWT，我们这里不需要csrf
          .and().csrf().disable();
	}

	/**
	 * 用户验证
	 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.authenticationProvider(daoAuthenticationProvider());
    }
    
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService(userDetailsService);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
	/**
	 * 过滤
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/plugins/**", "/favicon.ico");
	}
}
