package com.clark.online_edu.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clark.online.edu.entity.student.StudentInfo;
import com.clark.online.edu.util.Result;
import com.clark.online_edu.student.service.StudentService;

/**
 * 学生请求控制器
 * 
 * @author 大仙
 *
 */
@RestController
public class StudentInfoController {
	/**
	 * 学生业务接口
	 */
	@Autowired
	private StudentService studentService;

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_Teacher_LV1')")
	public Result<Map<String, Object>> getStudentInfo(@PathVariable("id")String id) {
		return studentService.getStdeuntInfo(id);
	}
    /**
     * 修改客户信息
     * @param id           客户ID
     * @param customerInfo 客户信息
     * @return
     */
    @PutMapping("/{id}")
    @ResponseBody
	public Result updateStudentInfo(@PathVariable String id,@RequestBody StudentInfo studentInfo) {
    	return studentService.updateStudentInfo(studentInfo);
    }
    /**
     * 新建客户
     * @param customerInfo
     * @return
     */
    @PostMapping
    @ResponseBody
    public Result insertStudentInfo(@RequestBody StudentInfo studentInfo) {
    	return studentService.insertStudentInfo(studentInfo);
    }

}
