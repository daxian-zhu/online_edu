package com.clark.online.edu.entity.uc;

import com.clark.online.edu.entity.ParentEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户和角色关联记录
 * @author 大仙
 *
 */
@Data
//equals和hashcode的重写使用父类属性
@EqualsAndHashCode(callSuper=true)
public class UC_UserAndRole extends ParentEntity{
	/**
	 * 用户主键
	 */
	private String userId;
	/**
	 * 角色主键
	 */
	private String roleId;

}
