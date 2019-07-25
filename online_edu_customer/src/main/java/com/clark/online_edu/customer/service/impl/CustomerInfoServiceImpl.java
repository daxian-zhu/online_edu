package com.clark.online_edu.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clark.online.edu.entity.customer.CustomerInfo;
import com.clark.online.edu.entity.uc.UC_User;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.util.DateUtil;
import com.clark.online.edu.util.Result;
import com.clark.online_edu.customer.dao.CustomerInfoDao;
import com.clark.online_edu.customer.service.CustomerInfoService;
import com.clark.online_edu.http.CurrentHttpServletRequest;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
/**
 * 客户业务接口实现
 * @author 大仙
 *
 */
@Service
public class CustomerInfoServiceImpl implements CustomerInfoService,CurrentHttpServletRequest{
	/**
	 * 注入客户信息数据接口
	 */
	@Autowired
	private CustomerInfoDao customerInfoDao;

	@Override
	@LcnTransaction
	@Transactional
	public Result updateCustomerInfo(CustomerInfo customerInfo) {
		if(customerInfo.getId()==null) {
			return Result.failure(ResponeCode.FAIL_1001);
		}
		if(customerInfo.getId().equals("cfc9c521-ae8c-11e9-b168-00163e0c9f02")) {
			throw new RuntimeException("就错了");
		}
		UC_User uc_User = getUser();
		customerInfo.setUpdateUser(uc_User.getId());
		customerInfo.setUpdateDate(DateUtil.getNowDateTime());
		customerInfoDao.updateCustomerInfo(customerInfo);
		return Result.OK();
	}

	@Override
	public Result insertCustomerInfo(CustomerInfo customerInfo) {
		UC_User uc_User = getUser();
		customerInfo.setCreateUser(uc_User.getId());
		customerInfo.setCreateDate(DateUtil.getNowDateTime());
		customerInfo.setUpdateUser(uc_User.getId());
		customerInfo.setUpdateDate(DateUtil.getNowDateTime());
		customerInfoDao.insertCustomerInfo(customerInfo);
		return Result.OK().setData(customerInfo.getId());
	}

}
