package com.ncu.clothwholesale.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.clothwholesale.mapper.WarehouseMapper;
import com.ncu.clothwholesale.service.WarehouseService;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;

@Service
public class WarehouseServiceImpl implements WarehouseService {
	@Autowired
	private WarehouseMapper warehouseMapper;

	@Override
	public Object listByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = warehouseMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

}
