package com.clark.online.edu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.clark.online.edu.entity.uc.UC_Role;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.service.RoleService;
import com.clark.online.edu.util.Result;
/**
 * 角色业务实现
 * @author 大仙
 *
 */
@Component
public class RoleServiceImpl implements RoleService{
	
	/**
	 * 配置日志
	 */
	private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Override
	public Result<List<UC_Role>> getRoleByUserId(String userId) {
		// TODO Auto-generated method stub
		logger.info("调用{}失败","findByUsername");
	    return Result.failure(ResponeCode.FAIL_1002);
	}

}
