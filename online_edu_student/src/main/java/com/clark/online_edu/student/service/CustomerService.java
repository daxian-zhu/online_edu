package com.clark.online_edu.student.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clark.online.edu.entity.customer.CustomerInfo;
import com.clark.online.edu.util.Result;
import com.clark.online_edu.student.config.FeignConfiguration;
import com.clark.online_edu.student.service.impl.CustomerServiceImpl;


@FeignClient(name = "customer"
,fallback = CustomerServiceImpl.class
,configuration=FeignConfiguration.class
)
public interface CustomerService {
	
	/**
	 * 通过ID获取客户信息
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Result<Map<String, Object>> getCustomerInfo(String id);
	/**
	 * 修改客户信息
	 * @param id
	 * @param customerInfo
	 * @return
	 */
	@PutMapping("/{id}")
	public Result updateCustomerInfo(@PathVariable("id") String id, @RequestBody CustomerInfo customerInfo);

}
