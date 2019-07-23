package com.clark.online.edu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clark.online.edu.entity.uc.UC_User;
import com.clark.online.edu.service.impl.UserServiceImpl;
import com.clark.online.edu.util.Result;

/**
 * 用户业务接口
 * @author 大仙
 *
 */
@FeignClient(name = "user-center",fallback = UserServiceImpl.class)
public interface UserService {
	/**
	 * 根据用户名
	 * @param username
	 * @return
	 */
	@GetMapping("user/{username}")
	public Result<UC_User> findByUsername(@PathVariable("username") String username);

}
