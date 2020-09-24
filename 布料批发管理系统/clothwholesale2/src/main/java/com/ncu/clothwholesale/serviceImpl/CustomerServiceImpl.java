package com.ncu.clothwholesale.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.clothwholesale.mapper.CusMonIORecMapper;
import com.ncu.clothwholesale.mapper.CustomerMapper;
import com.ncu.clothwholesale.mapper.ShippingAddrMapper;
import com.ncu.clothwholesale.pojo.CusMonIORec;
import com.ncu.clothwholesale.pojo.Customer;
import com.ncu.clothwholesale.pojo.ShippingAddr;
import com.ncu.clothwholesale.pojo.ShippingAddrExample;
import com.ncu.clothwholesale.pojo.ShippingAddrExample.Criteria;
import com.ncu.clothwholesale.service.CustomerService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ShippingAddrMapper addrMapper;
	@Autowired
	private CusMonIORecMapper cusMonIOMapper;
	
	@Override
	public Customer login(String username,String pwd) throws BusinessException{
		Customer customer = customerMapper.selectByPrimaryKey(username);
		if(customer != null){
			if(!customer.getPassword().equals(pwd))
				throw new BusinessException("密码不正确！");
		}else{
			throw new BusinessException("未找到用户名!");
		}
		
		return customer;
	}

	@Override
	public boolean addCustomer(Customer c) throws Exception {
		if(c !=null)
			if(customerMapper.insert(c)==1)
				return true;
		return false;
	}

	@Override
	public boolean updateCustomerInfo(Customer c) throws Exception {
		if(c!=null)
			if(customerMapper.updateByPrimaryKey(c)==1)
				return true;
		
		return false;
	}

	@Override
	public List<CusMonIORec> selectCusMonIORecsByCustomer(String username)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object listByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = customerMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public List<ShippingAddr> findAddressByUsername(String username) throws Exception {
		ShippingAddrExample example = new ShippingAddrExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		
		List<ShippingAddr> list = addrMapper.selectByExample(example);
		if(list.size()>0){
			return list;
		}else{
			throw new BusinessException("未找到收货地址");
		}
	}

	@Override
	public Object listIOByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = cusMonIOMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}
	
	@Override
	public boolean addShippingAddr(ShippingAddr addr) throws Exception {
		if(addrMapper.insertSelective(addr)==1){
			return true;
		}else{
			throw new BusinessException("插入默认地址不成功");
		}
	}
	
}
