package com.clark.online.edu.service;

import com.clark.online.edu.entity.uc.UC_User;
import com.clark.online.edu.util.Result;

/**
 * 用户相关业务接口
 * @author 大仙
 *
 */
public interface UserService {
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public Result<UC_User> findByUsername(String username);
}
