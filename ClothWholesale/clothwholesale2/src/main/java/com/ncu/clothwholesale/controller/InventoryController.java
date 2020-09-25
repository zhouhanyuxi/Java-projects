
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
import com.ncu.clothwholesale.pojo.Admin;
import com.ncu.clothwholesale.service.InventoryService;
import com.ncu.clothwholesale.service.PurchaseService;
import com.ncu.clothwholesale.service.WholesaleService;
import com.ncu.clothwholesale.tool.BaseConstrant;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.CommonUtil;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private PurchaseService purcService;
	@Autowired
	private WholesaleService wholeService;
	
	@RequestMapping("/listIO")
	public Object listIOByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(!admin.getAdminType().equals("GJ"))
			args.put("adminCode", admin.getAdminCode());
		if(args.containsValue("-1"))
			args.remove("IOMark");
		return ResultGenerator.genSuccessResult(inventoryService.listIOByCondition(args));
	}
	@RequestMapping("/list")
	public Object listByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(inventoryService.listByCondition(args));
	}
	@RequestMapping("/listPurcItem")
	public Object listPurcItemToInByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		args.put("state", BaseConstrant.PURCHASE_ITEM_STATE_STORING);
		return ResultGenerator.genSuccessResult(purcService.listPurcItemByCondition(args));
	}
	@RequestMapping("/purcIn")
	@ResponseBody
	public JSONObject purchaseItemIn(@RequestParam String warehouseCode, 
			@RequestParam String purchaseItemCode,HttpServletRequest request){
		JSONObject json = new JSONObject();
		if(request.getSession().getAttribute("admin")!=null){
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			try {
				if(inventoryService.putPurchaseItemIn(warehouseCode,purchaseItemCode,admin.getAdminCode())){
					json.put("success", true);
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
		}
		return json;
	}
	
	@RequestMapping("/listWholeItem")
	public Object listWholeItemToOutByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		args.put("state", BaseConstrant.WHOLESALE_ORDER_STATE_SHIPPING);
		return ResultGenerator.genSuccessResult(wholeService.listWholeItemByCondition(args));
	}
	@RequestMapping("/wholeOut")
	@ResponseBody
	public JSONObject wholesaleItemOut(@RequestParam String wholesaleItemCode,HttpServletRequest request){
		JSONObject json = new JSONObject();
		if(request.getSession().getAttribute("admin")!=null){
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			try {
				String warehouseCode = inventoryService.putWholesaleItemOut(wholesaleItemCode,admin.getAdminCode());
				if(warehouseCode!= null){
					json.put("success", true);
					json.put("data", warehouseCode);
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
		}
		return json;
	}
}