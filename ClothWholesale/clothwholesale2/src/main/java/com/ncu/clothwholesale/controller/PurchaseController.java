package com.ncu.clothwholesale.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.base.frame.ResultGenerator;
import com.ncu.clothwholesale.dto.PurchaseOrderSearch;
import com.ncu.clothwholesale.pojo.Admin;
import com.ncu.clothwholesale.pojo.PurchaseItem;
import com.ncu.clothwholesale.pojo.PurchaseOrder;
import com.ncu.clothwholesale.pojo.Supplier;
import com.ncu.clothwholesale.service.PurchaseService;
import com.ncu.clothwholesale.service.SupplierService;
import com.ncu.clothwholesale.serviceImpl.PurchaseServiceImpl;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.CommonUtil;
import com.ncu.clothwholesale.tool.ValidateUtil;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseServiceImpl purcServiceImpl;
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/createOrd")
	@ResponseBody
	public JSONObject createPurchaseOrder(@RequestParam String supplierCode,HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		PurchaseOrder pOrder = new PurchaseOrder();
		System.out.println("进入controller");
		if(request.getSession().getAttribute("admin")!=null){
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			if(!ValidateUtil.JudgeEmpty(admin.getAdminCode()) && !ValidateUtil.JudgeEmpty(supplierCode)){
				try {
					pOrder.setAdminCode(admin.getAdminCode());
					pOrder.setSupplierCode(supplierCode);
					Supplier s = supplierService.findSupplierById(supplierCode);
					PurchaseOrder p = purcServiceImpl.createPurchaseOrder(pOrder);
					if(p != null){
						json.put("success", true);
						json.put("message", p);
					}else{
						json.put("success", false);
						json.put("message", "创建采购订单失败！");
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
		}
		return json;
	}
	
	
	@RequestMapping("/addItem")
	@ResponseBody
	public JSONObject addPurchaseItem(@RequestParam String purchaseOrdCode,@RequestParam String modelCode,@RequestParam String totalNum,@RequestParam String originalPrice){
		JSONObject json = new JSONObject();
		int num = Integer.parseInt(totalNum);
		float price = Float.parseFloat(originalPrice);
		if(ValidateUtil.JudgeEmpty(modelCode) || ValidateUtil.JudgeEmpty(purchaseOrdCode)
				|| num<=0 ||price<=0){
			json.put("success", false);
			json.put("message", "请正确填写信息！");
		}else{
			try {
				PurchaseItem pItem = new PurchaseItem();
				pItem.setModelCode(modelCode);
				pItem.setOrignalPrice(price);
				pItem.setTotalNum(num);
				pItem.setPurchaseOrdCode(purchaseOrdCode);
				
				String pItemCode = purchaseService.createPurchaseItem(pItem);
				if(!ValidateUtil.JudgeEmpty(pItemCode)){
					json.put("success", true);
					json.put("message", pItemCode);
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
	
	@RequestMapping("payForItem")
	@ResponseBody
	public JSONObject payforPurchaseItem(@RequestParam String pItemCode,@RequestParam Double price,HttpServletRequest request){
		JSONObject json = new JSONObject();
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		String adminCode = admin.getAdminCode();
		if(!ValidateUtil.JudgeEmpty(pItemCode)){
			try {
				if(purchaseService.payForPurchaseItem(pItemCode,price,adminCode)){
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
	
	@RequestMapping("/list")
	@ResponseBody
	public JSONObject findPurchaseOrder(@RequestBody PurchaseOrderSearch pOrderSearch,HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		String adminCode = admin.getAdminCode();
		try {
			List<PurchaseOrder> list = (List<PurchaseOrder>) purcServiceImpl.findPurchaseOrders(pOrderSearch, adminCode);
			if(list!=null && list.size()>0){
				json.put("success", true);
				json.put("data", list);
				System.out.println(json.toString());
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
//	public Map<String, Object> findPurchaseOrder(@RequestBody PurchaseOrderSearch pOrderSearch,HttpServletRequest request){
//		System.out.println(pOrderSearch.toString());
//		Map<String, Object> map = new HashMap<String, Object>();
//		Admin admin = (Admin)request.getSession().getAttribute("admin");
//		String adminCode = admin.getAdminCode();
//		try {
//			List<PurchaseOrder> list = purcServiceImpl.findPurchaseOrders(pOrderSearch, adminCode);
//			if(list!=null && list.size()>0){
//				map.put("success", true);
//				map.put("data", list);
//				System.out.println(map.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			map.put("success", false);
//			map.put("message", e.getMessage());
//		}
//		
//		return map;
//	}


	
	@RequestMapping("/listOrder")
	public Object listPorderByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);
		if(args.get("type")=="1"){
			args.remove("type");
			args.put("type", 1);
		}else if(args.get("type")=="0"){
			args.remove("type");
			args.put("type", 0);
		}
		
		System.out.println(args.toString());
		return ResultGenerator.genSuccessResult(purchaseService.listByCondition(args));
	}
	
	@RequestMapping("/listIO")
	public Object listPMoneyIOByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		
		if(request.getSession().getAttribute("admin")!=null){
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			if(admin.getAdminType().equals("CG")){
				args.put("adminCode", admin.getAdminCode());
			}
			args.put("reason", "CG");
			return ResultGenerator.genSuccessResult(purchaseService.listPMoneyIOByCondition(args));
		}
		return null;
	}
	@RequestMapping("/listItem")
	public Object listPitemByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);
		if(args.get("type")=="-1"){
			args.remove("type");
		}
		
		return ResultGenerator.genSuccessResult(purchaseService.listPurcItemByCondition(args));
	}
	@RequestMapping("/applyIn")
	@ResponseBody
	public JSONObject applyPurcItemIn(@RequestParam String pItemCode){
		JSONObject json = new JSONObject();
		
		try {
			if(purchaseService.purchaseInApply(pItemCode)){
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
