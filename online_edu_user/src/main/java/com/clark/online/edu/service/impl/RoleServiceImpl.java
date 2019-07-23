package com.clark.online.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clark.online.edu.entity.uc.UC_Role;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.mapper.RoleMapper;
import com.clark.online.edu.service.RoleService;
import com.clark.online.edu.util.Result;

@Service
public class RoleServiceImpl implements RoleService{
	/**
	 * 角色业务接口
	 */
	@Autowired
	private RoleMapper roleMapper;

	@SuppressWarnings("unchecked")
	@Override
	public Result<List<UC_Role>> getRoleByUserId(String userId) {
		if(userId==null) {
			return Result.failure(ResponeCode.FAIL_1001);
		}
		List<UC_Role> roles = roleMapper.getRoleByUserId(userId);
		return Result.OK().setData(roles);
	}

}
