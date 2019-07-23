package com.clark.online.edu.service;
/**
 * 角色业务接口
 * @author 大仙
 *
 */

import java.util.List;

import com.clark.online.edu.entity.uc.UC_Role;
import com.clark.online.edu.util.Result;

public interface RoleService {
	/**
	 * 根据用户Id查询角色列表
	 * @param userId
	 * @return
	 */
	public Result<List<UC_Role>> getRoleByUserId(String userId);

}
