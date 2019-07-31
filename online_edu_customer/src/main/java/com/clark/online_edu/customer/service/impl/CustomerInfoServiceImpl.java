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
import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
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
	//事物的参与方
	@LcnTransaction(propagation = DTXPropagation.SUPPORTS)
	@Transactional
	public Result updateCustomerInfo(CustomerInfo customerInfo) {
		if(customerInfo.getId()==null) {
			return Result.failure(ResponeCode.FAIL_1001);
		}
		String groupId = TracingContext.tracing().groupId();
		String applicationId = Transactions.getApplicationId();
		System.out.println(groupId);
		System.out.println(applicationId);
		groupId = null;
		if(groupId.equals("aa")) {
			System.out.println("aa");
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
