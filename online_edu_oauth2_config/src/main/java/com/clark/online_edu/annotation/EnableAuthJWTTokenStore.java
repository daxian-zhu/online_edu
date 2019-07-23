package com.clark.online_edu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.clark.online_edu.store.AuthJWTTokenStore;

/**
 * 在启动类上添加该注解来----开启 JWT 令牌存储（授权服务器-非对称加密）
 * @author 大仙
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AuthJWTTokenStore.class)
public @interface EnableAuthJWTTokenStore {
}
