package com.clark.online_edu.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * redis token存储
 * 
 * @author 大仙
 *
 */
public class MyRedisTokenStore {
	
	@Autowired
	private RedisConnectionFactory dataSource;

	@Bean("authTokenStore")
	public TokenStore tokenStore() {
		return new RedisTokenStore(dataSource);
	}
}
