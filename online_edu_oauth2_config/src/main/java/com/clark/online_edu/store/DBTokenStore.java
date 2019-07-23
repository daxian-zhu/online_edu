package com.clark.online_edu.store;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
/**
 * 使用数据库存取令牌
 * @author 大仙
 *
 */
public class DBTokenStore {
    @Autowired
    private DataSource dataSource;

    @Bean("authTokenStore")
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }
}
