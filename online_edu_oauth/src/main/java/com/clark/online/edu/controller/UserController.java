package com.clark.online.edu.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取用户的控制器
 * @author 大仙
 *
 */
@RestController
public class UserController {
	
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
