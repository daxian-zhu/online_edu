package com.clark.online.edu.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clark.online.edu.entity.uc.UC_Role;
import com.clark.online.edu.service.impl.RoleServiceImpl;
import com.clark.online.edu.util.Result;

/**
 * 角色业务接口
 * @author 大仙
 *
 */
@FeignClient(name = "user-center",fallback = RoleServiceImpl.class)
public interface RoleService {
	/**
	 * 根据用户id查询用户拥有的角色列表
	 * @param userId
	 * @return
	 */
	@GetMapping("role/{userId}")
	public Result<List<UC_Role>> getRoleByUserId(@PathVariable("userId") String userId);

}
