package com.clark.online_edu.store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 资源服务器 TokenStore 配置类，使用 JWT RSA 非对称加密
 * @author 大仙
 *
 */
public class ResJWTTokenStore {
	
	private static final String PUBLIC_KEY = "pubkey.txt";

	@Autowired
	private ResourceServerProperties resourceServerProperties;

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(resJwtAccessTokenConverter());
	}

	@Bean("resJwtAccessTokenConverter")
	public JwtAccessTokenConverter resJwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessToken();
		String publicKey = getPubKey();
		converter.setVerifierKey(publicKey);
		//不设置这个会出现 Cannot convert access token to JSON
		converter.setVerifier(new RsaVerifier(publicKey));
		return converter;
	}

	/**
	 * 获取非对称加密公钥 Key
	 * 
	 * @return 公钥 Key
	 */
	private String getPubKey() {
		Resource resource = new ClassPathResource(ResJWTTokenStore.PUBLIC_KEY);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			return br.lines().collect(Collectors.joining("\n"));
		} catch (IOException ioe) {
			return getKeyFromAuthorizationServer();
		}
	}

	/**
	 * 通过访问授权服务器获取非对称加密公钥 Key
	 * 
	 * @return 公钥 Key
	 */
	private String getKeyFromAuthorizationServer() {
		ObjectMapper objectMapper = new ObjectMapper();
		String pubKey = new RestTemplate().getForObject(resourceServerProperties.getJwt().getKeyUri(), String.class);
		try {
			Map map = objectMapper.readValue(pubKey, Map.class);
			return map.get("value").toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
