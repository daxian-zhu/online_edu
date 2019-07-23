package com.clark.online.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.clark.online.edu.entity.uc.UC_Role;
import com.clark.online.edu.service.RoleService;
import com.clark.online.edu.util.Result;
/**
 * 角色业务接口
 * @author 大仙
 *
 */
@RestController
public class RoleController {
	/**
	 * 角色业务接口
	 */
	@Autowired
	private RoleService roleService;

	/**
	 * 根据用户id查询用户拥有的角色列表
	 * @param userId
	 * @return
	 */
	@GetMapping("role/{userId}")
	public Result<List<UC_Role>> getRoleByUserId(@PathVariable("userId") String userId){
		return roleService.getRoleByUserId(userId);
	}
}
