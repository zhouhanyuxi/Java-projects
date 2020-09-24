package com.ncu.clothwholesale.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.base.frame.ResultGenerator;
import com.ncu.clothwholesale.pojo.Admin;
import com.ncu.clothwholesale.service.AdminService;
import com.ncu.clothwholesale.tool.CommonUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/list")
	public Object listByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(adminService.listByCondition(args));
	}
	@RequestMapping("/view")
	@ResponseBody
	public JSONObject findAdminInfo(HttpServletRequest request){
		JSONObject json = new JSONObject();
		if(request.getSession().getAttribute("admin")!=null){
			Admin a = (Admin)request.getSession().getAttribute("admin");
			json.put("success", true);
			json.put("data", a);
		}else{
			json.put("success", false);
			json.put("message", "未登录");
		}
		return json;
	}
}
