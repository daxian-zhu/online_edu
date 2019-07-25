package com.clark.online.edu.entity.student;

import com.clark.online.edu.entity.ParentEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 学生信息实体
 * @author 大仙
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class StudentInfo extends ParentEntity{
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
	 * NCEE_TIME 高考时间
	 */
	private Integer nceeTime;
	/**
	 * PICTURE_URL  头像地址
	 */
	private String pictureUrl;
	/**
	 * USER_ID 关联用户Id
	 */
	private String userId;
	/**
	 * CUSTOMER_ID 关联客户Id
	 */
	private String customerId;
	/**
	 * BIND_WEIXIN 是否绑定微信  1:绑定 0:未绑定
	 */
	private Integer bindWeixin;
}
