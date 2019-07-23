package com.clark.online_edu.store;

import java.security.KeyPair;

import javax.annotation.Resource;

import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * 授权服务器 TokenStore 配置类，使用 JWT RSA 非对称加密
 * @author 大仙
 *
 */
public class AuthJWTTokenStore {

    @Bean("keyProp")
    public KeyProperties keyProperties(){
        return new KeyProperties();
    }

    @Resource(name = "keyProp")
    private KeyProperties keyProperties;

    @Bean("authTokenStore")
    public TokenStore tokenStore() {
        return new JwtTokenStore(authJwtAccessTokenConverter());
    }

    @Bean("authJwtAccessTokenConverter")
    public JwtAccessTokenConverter authJwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessToken();
        KeyPair keyPair = new KeyStoreKeyFactory
                (keyProperties.getKeyStore().getLocation(), keyProperties.getKeyStore().getSecret().toCharArray())
                .getKeyPair(keyProperties.getKeyStore().getAlias());
        converter.setKeyPair(keyPair);
        System.out.println("CCC=================================="+keyPair);
        return converter;
    }

}
