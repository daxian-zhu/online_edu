package com.clark.online.edu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.clark.online.edu.entity.uc.UC_User;

/**
 * 用户数据接口
 * @author 大仙
 *
 */
@Mapper
public interface UserMapper {
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	@Select("select * from uc_user where DR = 1 and STATUS = 1 and USERNAME = #{username}")
	public UC_User findByUsername(String username);

}
