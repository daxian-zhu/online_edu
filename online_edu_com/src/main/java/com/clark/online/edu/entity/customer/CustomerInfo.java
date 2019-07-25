package com.clark.online.edu.entity.customer;

import com.clark.online.edu.entity.ParentEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 客户信息实体
 * @author 大仙
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerInfo extends ParentEntity{
	/**
	 * NAME 客户名称
	 */
	private String name;
	/**
	 * CONTACT_MOBILE 客户电话
	 */
	private String contactMonile;
	/**
	 * SEX 性别
	 */
	private Integer sex;
	/**
	 * AGE 年龄
	 */
	private Integer age;
	/**
	 * STATUS 当前状态 0:待分配 1:TMK 持有 2：CC持有 3:TMK放弃 4：CC放弃
	 */
	private Integer status;
	/**
	 * COMMENT 备注
	 */
	private String comment;

}
