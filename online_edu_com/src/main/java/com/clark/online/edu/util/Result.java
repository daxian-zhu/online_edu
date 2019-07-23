package com.clark.online.edu.util;

import com.clark.online.edu.enums.ResponeCode;

/**
 * 处理结果
 * @author 大仙
 *
 */
@SuppressWarnings("all")
public class Result<T>{
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据实体
     */
    private T data;
    /**
     * 请求成功
     * @return
     */
    public static Result OK() {
    	Result result = new Result();
    	result.setCode(ResponeCode.OK.getCode());
    	result.setMsg(ResponeCode.OK.getValue());
    	return result;
    }
    /**
     * 请求失败
     * @param responeCode
     * @return
     */
    public static Result failure(ResponeCode responeCode) {
    	Result result = new Result();
    	result.setCode(responeCode.getCode());
    	result.setMsg(responeCode.getValue());
    	return result;
    }
    /**
     * 请求失败
     * @param code
     * @param msg
     * @return
     */
    public static Result failure(String msg) {
    	Result result = new Result();
    	result.setCode(1000);
    	result.setMsg(msg);
    	return result;
    }
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public Result setData(T data) {
		this.data = data;
		return this;
	}
    
    
}
