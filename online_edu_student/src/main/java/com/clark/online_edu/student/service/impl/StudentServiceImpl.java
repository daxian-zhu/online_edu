package com.clark.online_edu.student.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clark.online.edu.entity.customer.CustomerInfo;
import com.clark.online.edu.entity.student.StudentInfo;
import com.clark.online.edu.entity.uc.UC_User;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.util.DateUtil;
import com.clark.online.edu.util.Result;
import com.clark.online_edu.http.CurrentHttpServletRequest;
import com.clark.online_edu.student.dao.StudentInfoDao;
import com.clark.online_edu.student.service.CustomerService;
import com.clark.online_edu.student.service.StudentService;
import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
/**
 * 学生业务相关
 * @author 大仙
 *
 */
@Service
public class StudentServiceImpl implements StudentService,CurrentHttpServletRequest{
	/**
	 * 调用客户模块业务
	 */
	@Autowired
	private CustomerService customerService;
	/**
	 * 学生信息数据接口
	 */
	@Autowired
	private StudentInfoDao studentInfoDao;

	@Override
	public Result<Map<String, Object>> getStdeuntInfo(String id) {
		for (int i = 0; i < 60; i++) {
			try {
				System.out.println("======"+i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Map<String, Object> data = new HashMap<String, Object>();
    	data.put("studentName", "大仙超帅");
    	data.put("courseNum", "60");
    	data.put("studentLevel", "A");
    	String customerId = "11";
    	//获取客户信息
    	Result<Map<String, Object>> custmerInfo =  customerService.getCustomerInfo(customerId);;
		//判断获取正常还是失败
    	if(custmerInfo.getCode()==ResponeCode.OK.getCode()) {
    		data.put("customerInfo", custmerInfo.getData());
    	}else {
    		return Result.failure(custmerInfo.getMsg());
    	}
    	return Result.OK().setData(data);
	}
	
	@LcnTransaction(propagation = DTXPropagation.REQUIRED) //分布式事务注解
	@Transactional //本地事务注解
	@Override
	public Result updateStudentInfo(StudentInfo studentInfo) {
		if(studentInfo.getId()==null) {
			return Result.failure(ResponeCode.FAIL_1001);
		}
		UC_User uc_User = getUser();
		studentInfo.setUpdateUser(uc_User.getId());
		studentInfo.setUpdateDate(DateUtil.getNowDateTime());
		//更新学生信息
		studentInfoDao.updateStudentInfo(studentInfo);
		String groupId = TracingContext.tracing().groupId();
		String applicationId = Transactions.getApplicationId();
		System.out.println(groupId);
		System.out.println(applicationId);
		//构造客户信息，并更新客户信息
		CustomerInfo customer = new CustomerInfo();
		customer.setId(studentInfo.getCustomerId());
		customer.setAge(studentInfo.getAge());
		customer.setSex(studentInfo.getSex());
		customer.setName(studentInfo.getName());
		customer.setContactMonile(studentInfo.getContactMonile());
		customerService.updateCustomerInfo(customer.getId(), customer);
		//更新用户信息,暂时不处理
		
		return Result.OK();
	}

	@LcnTransaction //分布式事务注解
	@Transactional //本地事务注解
	@Override
	public Result insertStudentInfo(StudentInfo studentInfo) {
		UC_User uc_User = getUser();
		studentInfo.setUpdateUser(uc_User.getId());
		studentInfo.setUpdateDate(DateUtil.getNowDateTime());
		studentInfo.setCreateUser(uc_User.getId());
		studentInfo.setCreateDate(DateUtil.getNowDateTime());
		studentInfoDao.insertStudentInfo(studentInfo);
		CustomerInfo customer = new CustomerInfo();
		customer.setId(studentInfo.getCustomerId());
		customer.setAge(studentInfo.getAge());
		customer.setSex(studentInfo.getSex());
		customer.setName(studentInfo.getName());
		customerService.updateCustomerInfo("cfc9c521-ae8c-11e9-b168-00163e0c9f02", customer);
		return Result.OK().setData(studentInfo.getId());
	}
}
