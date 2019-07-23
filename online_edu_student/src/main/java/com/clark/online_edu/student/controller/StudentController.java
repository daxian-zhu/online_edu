package com.clark.online_edu.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clark.online.edu.util.Result;
import com.clark.online_edu.student.service.StudentService;

/**
 * 学生请求控制器
 * 
 * @author 大仙
 *
 */
@RestController
public class StudentController {
	/**
	 * 学生业务接口
	 */
	@Autowired
	private StudentService studentService;

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_Teacher_LV1')")
	public Result<Map<String, Object>> getStudentInfo(String id) {
		return studentService.getStdeuntInfo(id);
	}

}
