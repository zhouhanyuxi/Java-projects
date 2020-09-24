package com.ncu.clothwholesale.service;

import java.util.Map;

import com.ncu.clothwholesale.pojo.Admin;

public interface AdminService {
	public Admin login(String username,String pwd)throws Exception;

	public Object listByCondition(Map<String, Object> args);

}
