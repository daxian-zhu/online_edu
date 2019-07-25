package com.clark.online_edu.student.service;

import java.util.Map;

import com.clark.online.edu.entity.student.StudentInfo;
import com.clark.online.edu.util.Result;

public interface StudentService {
	
	/**
	 * 根据Id获取学生信息
	 * @param Id
	 * @return
	 */
	public Result<Map<String, Object>> getStdeuntInfo(String id);
	/**
	 * 修改学生信息
	 * @param studentInfo
	 * @return
	 */
	public Result updateStudentInfo(StudentInfo studentInfo);
	
	/**
	 * 创建学生
	 * @param studentInfo
	 * @return
	 */
	public Result insertStudentInfo(StudentInfo studentInfo);

}
