package com.clark.online_edu.customer.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.clark.online.edu.entity.customer.CustomerInfo;

public class CustomerInfoProvider {
	/**
	 * 修改客户信息
	 * @param customerInfo
	 * @return
	 */
	public String update(CustomerInfo customerInfo) {
		 return new SQL(){{
			 UPDATE("customer_info");
			 //姓名
			 if(customerInfo.getName() != null){
                 SET("NAME=#{name}");
             }  
			 //联系电话
			 if(customerInfo.getContactMonile() != null){
                 SET("CONTACT_MOBILE=#{contactMonile}");
             }   
			 //性别
			 if(customerInfo.getSex() != null){
                 SET("SEX=#{sex}");
             }   
			 //年龄
			 if(customerInfo.getAge() != null){
				 SET("AGE=#{age}");
			 }   
			 //当前状态
			 if(customerInfo.getStatus() != null){
				 SET("STATUS=#{status}");
			 }   
			 //备注
			 if(customerInfo.getComment() != null){
				 SET("COMMENT=#{comment}");
			 }   
			 //修改时间
			 if(customerInfo.getUpdateDate() != null){
				 SET("UPDATE_DATE=#{updateDate}");
			 }   
			 //修改人
			 if(customerInfo.getUpdateUser() != null){
				 SET("UPDATE_USER=#{updateUser}");
			 }   
			 WHERE("ID=#{id}");
		 }}.toString();
	}
	/**
	 * 插入客户
	 * @param customerInfo
	 * @return
	 */
	public String insert(CustomerInfo customerInfo) {
		return new SQL(){{
			 INSERT_INTO("customer_info");
			 //主键
			 VALUES("ID", "#{id}");
			 //姓名
             VALUES("NAME", "#{name}");
			 //联系电话
             VALUES("CONTACT_MOBILE", "#{contactMonile}");
			 //性别
             VALUES("SEX", "#{sex}");
			 //年龄
             VALUES("AGE", "#{age}");
			 //当前状态
             VALUES("STATUS", "#{status}");
			 //备注
             VALUES("COMMENT", "#{comment}");
			 //修改时间
             VALUES("UPDATE_DATE", "#{updateDate}");
			 //修改人
             VALUES("UPDATE_USER", "#{updateUser}");
             //修改时间
             VALUES("CREATE_DATE", "#{createDate}");
             //修改人
             VALUES("CREATE_USER", "#{createUser}");
		 }}.toString();
	}
}
