package com.clark.online.edu.enums;

/**
 * 响应结果枚举
 * 
 * @author 大仙
 *
 */
public enum ResponeCode {
	OK(1, "操作成功"),
	FAIL_500(500, "系统异常"), 
	FAIL_401(401, "权限认证失败"), 
	FAIL_1001(1001, "缺失请求参数"), 
	FAIL_1002(1002, "服务调用异常"), 
	FAIL_1003(1003, "token无效或缺失token");
	/**
	 * 状态码
	 */
	private Integer code;
	/**
	 * 值
	 */
	private String value;

	private ResponeCode(Integer code, String value) {
		this.code = code;
		this.value = value;
	}

	/**
	 * 根据code获取对应的value
	 * 
	 * @param code
	 * @return
	 */
	public static String getValue(Integer code) {
		for (ResponeCode c : ResponeCode.values()) {
			if (c.getCode() == code) {
				return c.value;
			}
		}
		return code + "";
	}

	/**
	 * 根据value获取对应的code
	 * 
	 * @param value
	 * @return
	 */
	public static Integer getCode(String value) {
		for (ResponeCode c : ResponeCode.values()) {
			if (c.getValue().equals(value)) {
				return c.getCode();
			}
		}
		return null;
	}

	/**
	 * 获取枚举所有的值
	 * 
	 * @return
	 */
	public static ResponeCode[] getSaleStatus() {
		ResponeCode[] saleStatus = ResponeCode.values();
		return saleStatus;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
