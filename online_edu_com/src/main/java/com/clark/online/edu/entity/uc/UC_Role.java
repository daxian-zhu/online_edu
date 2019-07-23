package com.clark.online.edu.entity.uc;

import com.clark.online.edu.entity.ParentEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色实体
 * @author 大仙
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class UC_Role extends ParentEntity{
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 值
	 */
	private String value;
	/**
	 * 状态 1:可用 -1:不可用
	 */
	private Byte status;

}
