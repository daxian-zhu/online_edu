package com.clark.online.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clark.online.edu.entity.uc.UC_Role;

/**
 * 角色数据接口
 * @author 大仙
 *
 */
@Mapper
public interface RoleMapper {
	/**
	 * 查询角色列表
	 * @param userId
	 * @return
	 */
	@Select("select ur.* from uc_role ur LEFT JOIN uc_user_and_role ucar ON ur.ID = ucar.ROLE_ID where ur.DR = 1 and ur.STATUS = 1 and ucar.DR = 1 and ucar.USER_ID = #{userId}")
	public List<UC_Role> getRoleByUserId(String userId);
}
