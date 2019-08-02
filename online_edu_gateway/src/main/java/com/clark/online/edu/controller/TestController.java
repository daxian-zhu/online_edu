package com.clark.online.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clark.online.edu.util.Result;

@RestController
public class TestController {
	
	@GetMapping("timeout")
	public Result timeOut() {
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result.OK();
	}

}
