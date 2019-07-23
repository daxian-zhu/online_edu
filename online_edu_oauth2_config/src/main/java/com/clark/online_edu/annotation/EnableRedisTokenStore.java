package com.clark.online_edu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.clark.online_edu.store.MyRedisTokenStore;

/**
 * 在启动类上添加该注解来----开启通过redis存储令牌
 * @author 大仙
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyRedisTokenStore.class)
public @interface EnableRedisTokenStore {
}
