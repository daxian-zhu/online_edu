package com.clark.online_edu.student.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.util.Result;
import com.clark.online_edu.student.service.CustomerService;
import com.clark.online_edu.student.service.StudentService;
/**
 * 学生业务相关
 * @author 大仙
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	/**
	 * 调用客户模块业务
	 */
	@Autowired
	private CustomerService customerService;

	@Override
	public Result<Map<String, Object>> getStdeuntInfo(String id) {
		Map<String, Object> data = new HashMap<String, Object>();
    	data.put("studentName", "大仙超帅");
    	data.put("courseNum", "60");
    	data.put("studentLevel", "A");
    	String customerId = "11";
    	//获取客户信息
    	Result<Map<String, Object>> custmerInfo = null;
		try {
			custmerInfo = customerService.getCustomerInfo(customerId);
		} catch (Exception e) {
			//获取客户信息出错，一般是没权限
			return Result.failure(e.getMessage());
		}
		//判断获取正常还是失败
    	if(custmerInfo.getCode()==ResponeCode.OK.getCode()) {
    		data.put("customerInfo", custmerInfo.getData());
    	}else {
    		return Result.failure(custmerInfo.getMsg());
    	}
    	return Result.OK().setData(data);
	}

}
