package com.clark.online_edu.customer.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.clark.online.edu.entity.customer.CustomerInfo;
import com.clark.online_edu.customer.dao.provider.CustomerInfoProvider;

@Mapper
public interface CustomerInfoDao {
	/**
	 * 修改客户信息
	 * @param customerInfo
	 */
	@UpdateProvider(type=CustomerInfoProvider.class,method="update")
	public void updateCustomerInfo(CustomerInfo customerInfo);
	/**
	 * 创建客户
	 * @param customerInfo
	 */
	@InsertProvider(type=CustomerInfoProvider.class,method="insert")
	@SelectKey(statement="SELECT UUID() FROM DUAL;", keyProperty="id", before=true, resultType=String.class)
	public void insertCustomerInfo(CustomerInfo customerInfo);
}
