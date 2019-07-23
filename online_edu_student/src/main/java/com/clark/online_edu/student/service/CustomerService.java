package com.clark.online_edu.student.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clark.online.edu.util.Result;
import com.clark.online_edu.student.config.FeignConfiguration;
import com.clark.online_edu.student.service.impl.CustomerServiceImpl;


@FeignClient(name = "customer",fallback = CustomerServiceImpl.class,configuration=FeignConfiguration.class)
public interface CustomerService {
	
	/**
	 * 通过ID获取客户信息
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	public Result<Map<String, Object>> getCustomerInfo(@PathVariable("id")String id);

}
