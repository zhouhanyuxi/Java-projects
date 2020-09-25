
package com.ncu.clothwholesale.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.base.frame.ResultGenerator;
import com.ncu.clothwholesale.pojo.Customer;
import com.ncu.clothwholesale.pojo.ShippingAddr;
import com.ncu.clothwholesale.service.AdminService;
import com.ncu.clothwholesale.service.CustomerService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.CommonUtil;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public Object listByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(customerService.listByCondition(args));
	}
	
	@RequestMapping("findAddress")
	@ResponseBody
	public JSONObject findAddressByUsername(HttpServletRequest request){
		JSONObject json = new JSONObject();
		if(request.getSession().getAttribute("customer")!=null){
			Customer c = (Customer) request.getSession().getAttribute("customer");
			try {
				List<ShippingAddr> list = customerService.findAddressByUsername(c.getUsername());
				json.put("success", true);
				json.put("data", list);
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
	
	@RequestMapping("/listIO")
	public Object listIOByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		if(request.getSession().getAttribute("customer")!=null){
			Customer customer = (Customer) request.getSession().getAttribute("customer");
			args.put("username", customer.getUsername());
		}
		if(args.containsValue("-1"))
			args.remove("reason");
		return ResultGenerator.genSuccessResult(customerService.listIOByCondition(args));
	}
}