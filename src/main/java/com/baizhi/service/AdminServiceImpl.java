package com.baizhi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Override
	public Object login(String username, String password) {
		Admin admin = adminDao.selectAdminByUsername(username);
		Map<String,String> map = new HashMap<String, String>();
		//如果admin为空，说明用户名不存在
		if(admin == null){
			map.put("status", "300");
			map.put("message", "用户名不存在！");
			return map;
		}else if(!admin.getPassword().equals(password)){
			map.put("status", "400");
			map.put("message", "密码不正确！");
			return map;
		}else{
			map.put("status", "200");
			map.put("message", "登录成功！");
			return map;
		}
	}

}
