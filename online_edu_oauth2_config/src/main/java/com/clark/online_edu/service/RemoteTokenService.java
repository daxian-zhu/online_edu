package com.clark.online_edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 过访问远程授权服务器 check_token 端点验证令牌
 * @author 大仙
 *
 */
public class RemoteTokenService {

    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Resource(name = "authServerProp")
    private AuthorizationServerProperties authorizationServerProperties;

    @Bean(name = "authServerProp")
    public AuthorizationServerProperties authorizationServerProperties(){
        return new AuthorizationServerProperties();
    }

    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl(authorizationServerProperties.getCheckTokenAccess());
        if (StringUtils.isEmpty(oAuth2ClientProperties.getClientId())) {
            remoteTokenServices.setClientId(oAuth2ClientProperties.getClientId());
        }
        if (StringUtils.isEmpty(oAuth2ClientProperties.getClientSecret())){
            remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
        }
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
        return remoteTokenServices;
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }

}
