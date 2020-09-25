package com.ncu.clothwholesale.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.base.frame.ResultGenerator;
import com.ncu.clothwholesale.pojo.Picture;
import com.ncu.clothwholesale.pojo.Product;
import com.ncu.clothwholesale.pojo.ProductModel;
import com.ncu.clothwholesale.pojo.SellPrice;
import com.ncu.clothwholesale.service.ProductService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.CommonUtil;
import com.ncu.clothwholesale.tool.ValidateUtil;
import com.ncu.clothwholesale.vo.ModelSaleInfo;
import com.ncu.clothwholesale.vo.ProductVO;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")
	public Object listByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(productService.listByCondition(args));
	}
	@RequestMapping("/listPic")
	public Object listWithPicByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);
		return ResultGenerator.genSuccessResult(productService.listWithPicByCondition(args));
	}
	
	@RequestMapping("/addProduct")
	@ResponseBody
	public JSONObject addProduct(@RequestBody ProductVO p){
		JSONObject json = new JSONObject();
		try {
			String productCode = productService.addProduct(p);
			if(productCode!=null){
				json.put("success", true);
				json.put("message", productCode);
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
	
	@RequestMapping("/addModel")
	@ResponseBody
	public JSONObject addModel(@RequestParam(value="productCode") String productCode,@RequestParam(value="modelName") String modelName,
			@RequestParam(value="file",required=true)MultipartFile file,HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		String path = request.getSession().getServletContext().getRealPath("service\\images");
		System.out.println(path);
		try {
			String pathString = productService.addModel(productCode,modelName,file,path);
			if(pathString!=null){
				json.put("success", true);
				json.put("message", pathString);
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
	
	@RequestMapping("/findBySupplier")
	@ResponseBody
	public JSONObject findProductById(@RequestParam String supplierCode){
		System.out.println("controller"+supplierCode);
		JSONObject json = new JSONObject();
		if(!ValidateUtil.JudgeEmpty(supplierCode)){
			try {
				List<Product> list = productService.findTProductById(supplierCode);
				System.out.println(list.size());
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
	
	@RequestMapping("/findModel")
	@ResponseBody
	public JSONObject findModelByProduct(@RequestParam String productCode){
		System.out.println("controller"+productCode);
		JSONObject json = new JSONObject();
		if(!ValidateUtil.JudgeEmpty(productCode)){
			try {
				List<ProductModel> list = productService.findModelByProduct(productCode);
				System.out.println(list.size());
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
	
	@RequestMapping("/findPic")
	@ResponseBody
	public JSONObject findPicByModel(@RequestParam String modelCode){
		System.out.println("controller"+modelCode);
		JSONObject json = new JSONObject();
		if(!ValidateUtil.JudgeEmpty(modelCode)){
			try {
				Picture p = productService.findPicByModel(modelCode);
				System.out.println(p.toString());
				json.put("success", true);
				json.put("data", p);
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
	
	@RequestMapping("/findById")
	@ResponseBody
	public JSONObject findById(@RequestParam String productCode){
		JSONObject json = new JSONObject();
		if(!ValidateUtil.JudgeEmpty(productCode)){
			try {
				List<Product> list = productService.findProductById(productCode);
				if(list.size()==1){
					json.put("success", true);
					json.put("data", list.get(0));
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
	
	@RequestMapping("/findPrice")
	@ResponseBody
	public JSONObject findPriceByProductCode(@RequestParam String productCode){
		JSONObject json = new JSONObject();
		if(!ValidateUtil.JudgeEmpty(productCode)){
			try {
				List<SellPrice> list = productService.findPriceByProductCode(productCode);
				if(list.size()>0){
					json.put("success", true);
					json.put("data", list);
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
	
	@RequestMapping("/findModelInfo")
	@ResponseBody
	public JSONObject findModelSaleInfoById(@RequestParam String modelCode){
		JSONObject json = new JSONObject();
		System.out.println("进入controller");
		if(!ValidateUtil.JudgeEmpty(modelCode)){
			try {
				ModelSaleInfo info = productService.findModelSaleInfoById(modelCode);
				System.out.println(info.toString());
				if(info!=null){
					json.put("success", true);
					json.put("data", info);
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
	
	@RequestMapping("/addPrice")
	@ResponseBody
	public JSONObject addPriceByProductCode(@RequestParam String productCode,
			@RequestParam int lowerLimit,@RequestParam float price){
		JSONObject json = new JSONObject();
		
		try {
			if(productService.addPriceByProductCode(lowerLimit,price,productCode)){
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
		return json;
	}
	
	@RequestMapping("/changeState")
	@ResponseBody
	public JSONObject changeProductStateById(@RequestParam String productCode){
		System.out.println("changeStateControllere");
		JSONObject json = new JSONObject();
		try {
			if(productService.updateProductStateById(productCode)){
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
		return json;
		
	}
	
}
