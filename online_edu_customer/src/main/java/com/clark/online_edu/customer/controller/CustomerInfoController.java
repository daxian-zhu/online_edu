package com.clark.online_edu.customer.controller;

import java.util.HashMap;
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

import com.clark.online.edu.entity.customer.CustomerInfo;
import com.clark.online.edu.util.Result;
import com.clark.online_edu.customer.service.CustomerInfoService;
/**
 * 客户信息接口
 * @author 大仙
 *
 */
@RestController
public class CustomerInfoController {
	/**
	 * 注入客户业务接口
	 */
	@Autowired
	private CustomerInfoService customerInfoService;
    /**
     * 获取客户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_admin')")
    public Result<Map<String, Object>> getCustomerinfo(@PathVariable("id")String id) {
    	Map<String, Object> data = new HashMap<String, Object>();
    	data.put("name", "大仙");
    	data.put("sex", "男");
    	data.put("comment", "超帅");
    	return Result.OK().setData(data);
    }
    /**
     * 修改客户信息
     * @param id           客户ID
     * @param customerInfo 客户信息
     * @return
     */
    @PutMapping("/{id}")
    @ResponseBody
	public Result updateCustomerInfo(@PathVariable String id,@RequestBody CustomerInfo customerInfo) {
    	return customerInfoService.updateCustomerInfo(customerInfo);
    }
    /**
     * 新建客户
     * @param customerInfo
     * @return
     */
    @PostMapping
    @ResponseBody
    public Result insertCustomerInfo(@RequestBody CustomerInfo customerInfo) {
    	return customerInfoService.insertCustomerInfo(customerInfo);
    }
}
