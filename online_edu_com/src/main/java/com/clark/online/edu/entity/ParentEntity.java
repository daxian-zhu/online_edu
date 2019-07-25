package com.clark.online.edu.entity;

import com.clark.online.edu.util.DateUtil;

import lombok.Data;

/**
 * 抽离父类实体，汇聚公共字段
 * @author 大仙
 *
 */
@Data
public class ParentEntity {
	/**
	 * 主键
	 */
	protected String id;
	/**
	 * 删除标志 1:正常  -1: 已删除
	 */
	protected Byte dr = 1;
	/**
	 * 创建人
	 */
	protected String createUser;
	/**
	 * 创建时间
	 */
	protected String createDate = DateUtil.getNowDateTime();
	/**
	 * 修改人
	 */
	protected String updateUser;
	/**
	 * 修改时间
	 */
	protected String updateDate = DateUtil.getNowDateTime();

}
