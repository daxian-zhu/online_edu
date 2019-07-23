package com.clark.online.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.clark.online.edu.entity.uc.UC_User;
import com.clark.online.edu.service.UserService;
import com.clark.online.edu.util.Result;

/**
 * 用户相关接口
 * @author 大仙
 *
 */
@RestController
public class UserController {
	/**
	 * 用户业务接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 根据用户名
	 * @param username
	 * @return
	 */
	@GetMapping("user/{username}")
	public Result<UC_User> findByUsername(@PathVariable("username") String username){
		return userService.findByUsername(username);
	}

}
