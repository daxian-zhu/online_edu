package com.clark.online_edu.student.dao.peorvider;

import org.apache.ibatis.jdbc.SQL;

import com.clark.online.edu.entity.customer.CustomerInfo;
import com.clark.online.edu.entity.student.StudentInfo;

/**
 * studentInfo提供相关SQL
 * @author 大仙
 *
 */
public class StduentInfoPeovider {
	
	/**
	 * 修改学员信息的SQL
	 * @param studentInfo
	 * @return
	 */
	public String update(StudentInfo studentInfo) {
		 return new SQL(){{
			 UPDATE("student_info");
			 //姓名
			 if(studentInfo.getName() != null){
                 SET("NAME=#{name}");
             }  
			 //联系电话
			 if(studentInfo.getContactMonile() != null){
                 SET("CONTACT_MOBILE=#{contactMonile}");
             }   
			 //性别
			 if(studentInfo.getSex() != null){
                 SET("SEX=#{sex}");
             }   
			 //年龄
			 if(studentInfo.getAge() != null){
				 SET("AGE=#{age}");
			 }   
			 //高考时间
			 if(studentInfo.getNceeTime() != null){
				 SET("NCEE_TIME=#{nceeTime}");
			 }   
			 //头像地址
			 if(studentInfo.getPictureUrl() != null){
				 SET("PICTURE_URL=#{pictureUrl}");
			 }   
			 //用户主键
			 if(studentInfo.getUserId() != null){
				 SET("USER_ID=#{userId}");
			 }   
			 //客户主键
			 if(studentInfo.getCustomerId() != null){
				 SET("CUSTOMER_ID=#{customerId}");
			 }   
			 //绑定微信
			 if(studentInfo.getBindWeixin() != null){
				 SET("BIND_WEIXIN=#{bindWeixin}");
			 }   
			 //修改时间
			 if(studentInfo.getUpdateDate() != null){
				 SET("UPDATE_DATE=#{updateDate}");
			 }   
			 //修改人
			 if(studentInfo.getUpdateUser() != null){
				 SET("UPDATE_USER=#{updateUser}");
			 }   
			 WHERE("ID=#{id}");
		 }}.toString();
	}
	/**
	 * 插入学生
	 * @param customerInfo
	 * @return
	 */
	public String insert(StudentInfo studentInfo) {
		return new SQL(){{
			 INSERT_INTO("student_info");
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
			 //高考时间
             VALUES("NCEE_TIME", "#{nceeTime}");
			 //头像地址
             VALUES("PICTURE_URL", "#{pictureUrl}");
             //用户主键
             VALUES("USER_ID", "#{userId}");
             //客户主键
             VALUES("CUSTOMER_ID", "#{customerId}");
             //绑定微信
             VALUES("BIND_WEIXIN", "#{bindWeixin}");
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
