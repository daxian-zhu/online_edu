package com.clark.online_edu.http;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.clark.online.edu.entity.uc.UC_User;

/**
 * 解析request的header
 * 
 * @author 大仙
 *
 */
public interface CurrentHttpServletRequest {
	/**
	 * 获取用户
	 * 
	 * @return
	 */
	public default UC_User getUser() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attrs == null) {
			throw new IllegalStateException("当前线程中不存在 Request 上下文");
		}
		UC_User user = new UC_User();
		// 获取Token
		Object accessToken = attrs.getRequest().getHeader("Authorization");
		if (accessToken != null) {
			DecodedJWT jwt = JWT.decode(accessToken.toString().replace("Bearer ", ""));
			Claim userInfo = jwt.getClaims().get("user_info");
			user = userInfo.as(UC_User.class);
		}
		return user;
	}

}
