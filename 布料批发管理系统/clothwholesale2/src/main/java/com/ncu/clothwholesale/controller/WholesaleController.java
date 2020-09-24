
package com.ncu.clothwholesale.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.base.frame.ResultGenerator;
import com.ncu.clothwholesale.dto.WholesaleOrderInfo;
import com.ncu.clothwholesale.pojo.Admin;
import com.ncu.clothwholesale.pojo.Customer;
import com.ncu.clothwholesale.pojo.WholesaleItem;
import com.ncu.clothwholesale.pojo.WholesaleOrder;
import com.ncu.clothwholesale.service.WholesaleService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.CommonUtil;

@RestController
@RequestMapping("/wholesale")
public class WholesaleController {

	@Autowired
	private WholesaleService wholesaleService;
	
	@RequestMapping("/list")
	public Object listByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request); 
		if(request.getSession().getAttribute("customer")!=null){
			Customer customer = (Customer) request.getSession().getAttribute("customer");
			args.put("username", customer.getUsername());
		}
		if(args.containsValue("-1"))
			args.remove("orderState");
		return ResultGenerator.genSuccessResult(wholesaleService.listByCondition(args));
	}
	

	@RequestMapping("/listCancel")
	public Object listCancelByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request); 
		if(args.containsValue("-1"))
			args.remove("orderState");
		return ResultGenerator.genSuccessResult(wholesaleService.listCancelByCondition(args));
	}
	
	@RequestMapping("/listIO")
	public Object listWMoneyIOByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		
		if(request.getSession().getAttribute("admin")!=null){
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			if(admin.getAdminType().equals("GJ")){
				args.put("adminCode", "");
			}else{
				args.put("adminCode", admin.getAdminType());
			}
			System.out.println("reason:"+args.get("reason"));
			return ResultGenerator.genSuccessResult(wholesaleService.listWMoneyIOByCondition(args));
		}
		return null;
	}
	
	@RequestMapping("/createOrd")
	@ResponseBody
	public JSONObject createWholesaleOrderAndItem(@RequestBody WholesaleOrderInfo info,HttpServletRequest request){
		JSONObject json = new JSONObject();
		System.out.println("jinrucontroller:"+info.toString());
		WholesaleOrder wOrder = new WholesaleOrder();
		wOrder.setShippingAddrNum(info.getShippingAddrNum());
		wOrder.setSumPrice(info.getSumPrice());
		wOrder.setUsername(((Customer)request.getSession().getAttribute("customer")).getUsername());
		
		try {
			wOrder = wholesaleService.createWholesaleOrder(wOrder);
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
		WholesaleItem wItem = new WholesaleItem();
		wItem.setModelCode(info.getModelCode());
		wItem.setPrice(info.getPrice());
		wItem.setTotalNum(info.getTotalNum());
		wItem.setTotalPrice((double)info.getPrice()*info.getTotalNum());
		wItem.setWholesaleOrdCode(wOrder.getWholesaleOrdCode());
		
		try {
			wholesaleService.createWholesaleItems(wItem);
			json.put("success", true);
			json.put("message", wItem.getWholesaleOrdCode());
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
		
		return json;
	}
	
	@RequestMapping("/pay")
	@ResponseBody
	public JSONObject payforItem(@RequestParam String wOrderCode,HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		try {
			wholesaleService.payWholesaleOrder(wOrderCode, customer.getUsername());
			json.put("success", true);
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
		
		return json;
	}
	
	@RequestMapping("/outApply")
	@ResponseBody
	public JSONObject wholesaleOutApply(@RequestParam String wholesasleOrdCode){
		JSONObject json = new JSONObject();
		
		try {
			if(wholesaleService.wholesaleOutApply(wholesasleOrdCode)){
				json.put("success", true);
			}else{
				json.put("success", false);
				json.put("message", "失败");
			}
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
		return json;
	}
	
}