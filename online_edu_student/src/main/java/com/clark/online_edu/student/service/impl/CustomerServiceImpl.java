package com.clark.online_edu.student.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.clark.online.edu.entity.customer.CustomerInfo;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.util.Result;
import com.clark.online_edu.student.service.CustomerService;

/**
 * customer调用熔断方法
 * @author 大仙
 *
 */
@Component
public class CustomerServiceImpl implements CustomerService{
	
	/**
	 * 配置日志
	 */
	private final static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Result<Map<String, Object>> getCustomerInfo(String id) {
		// TODO Auto-generated method stub
		logger.info("调用{}失败","getCustomerInfo");
	    return Result.failure(ResponeCode.FAIL_1002);
	}

	@Override
	public Result updateCustomerInfo(String id, CustomerInfo customerInfo) {
		// TODO Auto-generated method stub
		logger.info("调用{}失败","getCustomerInfo");
	    return Result.failure(ResponeCode.FAIL_1002);
	}

}
