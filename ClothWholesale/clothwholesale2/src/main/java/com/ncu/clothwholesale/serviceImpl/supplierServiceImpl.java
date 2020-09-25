package com.ncu.clothwholesale.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.clothwholesale.mapper.SupplierMapper;
import com.ncu.clothwholesale.pojo.Supplier;
import com.ncu.clothwholesale.service.SupplierService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;

@Service
public class supplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierMapper supplierMapper;
	
	@Override
	public Object listByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = supplierMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public Supplier findSupplierById(String supplierCode) throws Exception {
		Supplier s = supplierMapper.selectByPrimaryKey(supplierCode);
		if(s==null)
			throw new BusinessException("未找到供应商！");
		else{
			System.out.println(s.toString());
		}
		return s;
	}


}
