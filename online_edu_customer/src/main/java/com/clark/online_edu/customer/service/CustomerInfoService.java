package com.clark.online_edu.customer.service;

import com.clark.online.edu.entity.customer.CustomerInfo;
import com.clark.online.edu.util.Result;
/**
 * 客户业务相关接口
 * @author 大仙
 *
 */
public interface CustomerInfoService {
	
	/**
	 * 修改客户信息
	 * @param customerInfo
	 * @return
	 */
	public Result updateCustomerInfo(CustomerInfo customerInfo);
	
	/**
	 * 创建客户
	 * @param customerInfo
	 * @return
	 */
	public Result insertCustomerInfo(CustomerInfo customerInfo);

}
