package com.clark.online.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clark.online.edu.entity.uc.UC_User;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.mapper.UserMapper;
import com.clark.online.edu.service.UserService;
import com.clark.online.edu.util.Result;

/**
 * 用户业务接口实现
 * @author 大仙
 *
 */
@Service
public class UserServiceImpl implements UserService{
	/**
	 * 注入用户数据接口
	 */
	@Autowired
	private UserMapper userMapper;

	@Override
	public Result<UC_User> findByUsername(String username) {
		if(username==null) {
			return Result.failure(ResponeCode.FAIL_1001);
		}
		UC_User user = userMapper.findByUsername(username);
		if(user==null) {
			return Result.failure("当前账号不正确");
		}
		return Result.OK().setData(user);
	}
}
