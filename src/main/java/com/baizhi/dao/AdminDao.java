package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;

public interface AdminDao {
	Admin selectAdminByUsername(@Param("username") String username);
}
