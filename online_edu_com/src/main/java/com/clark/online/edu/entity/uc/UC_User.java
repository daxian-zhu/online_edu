package com.clark.online.edu.entity.uc;

import com.clark.online.edu.entity.ParentEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 用户实体
 * @author 大仙
 *
 */
@Data
//equals和hashcode的重写使用父类属性
@EqualsAndHashCode(callSuper=true)
public class UC_User extends ParentEntity{
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 登录名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 状态 1:可用 -1:不可用
	 */
	private Byte status;
	/**
	 * 性别
	 */
	private Byte sex;
	/**
	 * 年龄
	 */
	private Byte age;
	/**
	 * 头像地址
	 */
	private String headerPictureUrl;
	/**
	 * 电话
	 */
	private String telephone;

}
