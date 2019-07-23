package com.clark.online_edu.student.service;

import java.util.Map;

import com.clark.online.edu.util.Result;

public interface StudentService {
	
	/**
	 * 根据Id获取学生信息
	 * @param Id
	 * @return
	 */
	public Result<Map<String, Object>> getStdeuntInfo(String id);

}
