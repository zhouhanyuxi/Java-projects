package com.ncu.clothwholesale.service;

import java.util.List;
import java.util.Map;

import com.ncu.clothwholesale.pojo.CusMonIORec;
import com.ncu.clothwholesale.pojo.Customer;
import com.ncu.clothwholesale.pojo.ShippingAddr;


public interface CustomerService {
	public Customer login(String username,String pwd) throws Exception;
	public boolean addCustomer(Customer c)throws Exception;
	public boolean updateCustomerInfo(Customer c)throws Exception;
	
	public Object listByCondition(Map<String, Object> args);
	
	public List<CusMonIORec> selectCusMonIORecsByCustomer(String username)throws Exception;
	public List<ShippingAddr> findAddressByUsername(String username)throws Exception ;
	public Object listIOByCondition(Map<String, Object> args);
	boolean addShippingAddr(ShippingAddr addr)throws Exception;
}
