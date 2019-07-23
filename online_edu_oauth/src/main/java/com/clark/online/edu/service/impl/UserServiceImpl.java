package com.clark.online.edu.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.clark.online.edu.entity.uc.UC_User;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.service.UserService;
import com.clark.online.edu.util.Result;

import lombok.extern.slf4j.Slf4j;
/**
 * 短路回调
 * @author 大仙
 *
 */
@Component
public class UserServiceImpl implements UserService{
	/**
	 * 配置日志
	 */
	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public Result<UC_User> findByUsername(String username) {
		// TODO Auto-generated method stub
		logger.info("调用{}失败","findByUsername");
	    return Result.failure(ResponeCode.FAIL_1002);
	}

}
