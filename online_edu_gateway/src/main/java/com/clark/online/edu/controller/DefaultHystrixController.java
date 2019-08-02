package com.clark.online.edu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clark.online.edu.util.Result;

/**
 * 熔断降级默认请求
 * 
 * @author 大仙
 *
 */
@RestController
public class DefaultHystrixController {
	/**
	 * 默认回调
	 * @return
	 */
	@RequestMapping("/default-fallback")
	public Result defaultfallback() {
		return Result.failure("服务异常,网关执行熔断降级处理");
	}
}
