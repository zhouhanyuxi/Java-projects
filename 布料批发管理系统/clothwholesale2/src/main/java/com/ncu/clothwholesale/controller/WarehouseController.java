
package com.ncu.clothwholesale.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.base.frame.ResultGenerator;
import com.ncu.clothwholesale.service.AdminService;
import com.ncu.clothwholesale.service.WarehouseService;
import com.ncu.clothwholesale.tool.CommonUtil;
import com.ncu.clothwholesale.tool.ValidateUtil;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	@RequestMapping("/list")
	public Object listByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(warehouseService.listByCondition(args));
	}
	@RequestMapping("/findById")
	@ResponseBody
	public JSONObject findWarehouseById(@RequestParam String warehouseCode){
		JSONObject json = new JSONObject();
		//warehouseService.findById();
		return json;
	}
}
