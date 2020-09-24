package com.ncu.clothwholesale.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.clothwholesale.mapper.AdminMapper;
import com.ncu.clothwholesale.pojo.Admin;
import com.ncu.clothwholesale.service.AdminService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin login(String username,String pwd) throws BusinessException{
		Admin admin = adminMapper.selectByPrimaryKey(username);
		
		if(admin != null){
			System.out.println(admin.toString());
			if(!admin.getPassword().equals(pwd))
				throw new BusinessException("密码不正确！");
		}else{
			throw new BusinessException("未找到工号！");
		}
		return admin;
	}

	@Override
	public Object listByCondition(Map<String, Object> args) {
		// TODO Auto-generated method stub
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = adminMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}
	
}
