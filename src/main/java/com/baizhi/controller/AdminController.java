package com.baizhi.controller;

import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/login")
	public Object login(String username , String password,HttpServletRequest request){
		Map<String, String> map = (Map<String, String>) adminService.login(username, password);
		//进行判断，是否存session
		if(map.get("status").equals("200")){
			request.getSession().setAttribute("admin", "admin");
		}
		return map;
	}
}
