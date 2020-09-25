
package com.ncu.clothwholesale.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.base.frame.ResultGenerator;
import com.ncu.clothwholesale.pojo.Supplier;
import com.ncu.clothwholesale.service.SupplierService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.CommonUtil;
import com.ncu.clothwholesale.tool.ValidateUtil;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/list")
	public Object listByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(supplierService.listByCondition(args));
	}
	
	@RequestMapping("/findById")
	public JSONObject findSupplierById(@RequestParam String supplierCode){
		JSONObject json = new JSONObject();
		if(!ValidateUtil.JudgeEmpty(supplierCode)){
			try {
				Supplier s = supplierService.findSupplierById(supplierCode);
				json.put("success", true);
				json.put("data", s);
			} catch(BusinessException be){
				be.printStackTrace();
				json.put("success", false);
				json.put("message", be.getMessage());
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("success", false);
				json.put("message", "失败");
			}
		}
		
		return json;
		
	}
}
