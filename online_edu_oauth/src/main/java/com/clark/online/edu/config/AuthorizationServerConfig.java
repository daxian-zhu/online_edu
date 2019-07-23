package com.clark.online.edu.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;

import com.clark.online_edu.config.AuthServerConfig;

@Configuration
public class AuthorizationServerConfig extends AuthServerConfig {

    /**
     * 调用父类构造函数，设置令牌失效日期等信息
     */
    public AuthorizationServerConfig() {
        super((int)TimeUnit.DAYS.toSeconds(1), (int)TimeUnit.DAYS.toSeconds(1), false, true);
    }
    
}

