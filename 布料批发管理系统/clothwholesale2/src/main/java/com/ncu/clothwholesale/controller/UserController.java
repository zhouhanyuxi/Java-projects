package com.ncu.clothwholesale.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.mapper.ShippingAddrMapper;
import com.ncu.clothwholesale.pojo.Admin;
import com.ncu.clothwholesale.pojo.Customer;
import com.ncu.clothwholesale.pojo.ShippingAddr;
import com.ncu.clothwholesale.serviceImpl.AdminServiceImpl;
import com.ncu.clothwholesale.serviceImpl.CustomerServiceImpl;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.ValidateUtil;
import com.ncu.clothwholesale.vo.RegisterInfo;
import com.ncu.clothwholesale.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private CustomerServiceImpl customerService;
	
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject login(@RequestBody User user,HttpServletRequest request){
		JSONObject json = new JSONObject();
		Customer customer = null;
		Admin admin = null;
		try{
			if(user.getRole().equals("customer")){
				customer = customerService.login(user.getUsername(),user.getPassword());
				if(customer!=null){
					json.put("success", true);
					json.put("message", "customer");
					request.getSession().setAttribute("customer", customer);
				}
			}else if(user.getRole().equals("admin")){
				admin = adminService.login(user.getUsername(),user.getPassword());
				if(admin!=null){
					json.put("success", true);
					json.put("message", "admin");
					System.out.println(json.toString());
					request.getSession().setAttribute("admin", admin);
				}
			}
		}catch(BusinessException be){
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
//	public void login(@RequestBody User user,HttpServletRequest request,HttpServletResponse response){
//		User user2 = new User();
//		String ret = "";
//		try{
//			if(user.getRole().equals("customer")){
//				Customer customer = customerService.login(user.getUsername(),user.getPassword());
//				if(customer!=null){
//					user2.setUsername(customer.getUsername());
//					user2.setRole("客户");
//					ret = FastJsonUtil.ajaxResult(true, "customer");
//					request.getSession().setAttribute("customer", user2);
//				}
//			}else if(user.getRole().equals("admin")){
//				Admin admin = adminService.login(user.getUsername(),user.getPassword());
//				if(admin!=null){
//					user2.setUsername(admin.getAdminCode());
//					user2.setRole("管理员");
//					ret = FastJsonUtil.ajaxResult(true, "admin");
//					request.getSession().setAttribute("admin", user2);
//				}
//			}
//		}catch(Exception e){
//			ret = FastJsonUtil.ajaxResult(false, e.getMessage());
//		}
//		FastJsonUtil.write_json(response, ret);
//	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		System.out.println("准备退出");
		if(request.getSession().getAttribute("admin")!=null)
			request.getSession().removeAttribute("admin");
		else if(request.getSession().getAttribute("customer")!=null)
			request.getSession().removeAttribute("customer");
		System.out.println("已退出");
		
		
		return "login";
	}

	@RequestMapping("/register")
	@ResponseBody
	public JSONObject register(@RequestBody RegisterInfo info){
		JSONObject json = new JSONObject();
		Customer c = new Customer();
		if(!info.getPassword().equals(info.getPassword2())){
			json.put("success", false);
			json.put("message", "密码两次输入不一致");
		}else if(!ValidateUtil.isValidMobileNo(info.getMobile())){
			json.put("success", false);
			json.put("message", "手机号有误");
		}else if(!ValidateUtil.isValidEmail(info.getEmail())){
			json.put("success", false);
			json.put("message", "邮箱有误");
		}else{
			c.setContactAddr(info.getContactAddr());
			c.setCustomerName(info.getCustomerName());
			c.setEmail(info.getEmail());
			c.setMobile(info.getMobile());
			c.setPassword(info.getPassword());
			c.setPostcode(info.getPostcode());
			c.setUsername(info.getUsername());
			try {
				customerService.addCustomer(c);
				ShippingAddr addr = new ShippingAddr();
				addr.setContactName(info.getCustomerName());
				addr.setEmail(info.getEmail());
				addr.setMobile(info.getMobile());
				addr.setPostcode(info.getPostcode());
				addr.setShippingAddr(info.getContactAddr());
				addr.setUsername(info.getUsername());
				if(customerService.addShippingAddr(addr)){
					
				}
				
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
		}
		return json;
	}
}
