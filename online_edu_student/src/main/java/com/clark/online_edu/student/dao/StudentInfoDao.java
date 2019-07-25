package com.clark.online_edu.student.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.clark.online.edu.entity.student.StudentInfo;
import com.clark.online_edu.student.dao.peorvider.StduentInfoPeovider;

@Mapper
public interface StudentInfoDao {
	
	/**
	 * 修改学生信息
	 * @param studentInfo
	 */
	@UpdateProvider(type=StduentInfoPeovider.class,method="update")
	public void updateStudentInfo(StudentInfo studentInfo);
	
	/**
	 * 创建客户
	 * @param customerInfo
	 */
	@InsertProvider(type=StduentInfoPeovider.class,method="insert")
	@SelectKey(statement="SELECT UUID() FROM DUAL;", keyProperty="id", before=true, resultType=String.class)
	public void insertStudentInfo(StudentInfo studentInfo);

}
