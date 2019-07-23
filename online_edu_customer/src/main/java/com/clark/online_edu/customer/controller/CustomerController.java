package com.clark.online_edu.customer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.clark.online.edu.util.Result;

@RestController
public class CustomerController {
	
    /**
     * 只有 ROLE_ADMIN 角色的用户才能访问
     * @return 问候信息
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_admin')")
    public String helloAdmin(){
        return "hello Admin";
    }
    /**
     * 只有 ROLE_Teacher_LV1 角色的用户才能访问
     * @return 问候信息
     */
    @GetMapping("/teacher")
    @PreAuthorize("hasRole('ROLE_Teacher_LV1')")
    public String helloTeacher(){
    	return "hello Teacher";
    }
    
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
}
