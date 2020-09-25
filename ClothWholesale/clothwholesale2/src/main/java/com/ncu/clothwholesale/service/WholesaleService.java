package com.ncu.clothwholesale.service;

import java.util.Map;

import com.ncu.clothwholesale.pojo.WholesaleItem;
import com.ncu.clothwholesale.pojo.WholesaleOrder;

public interface WholesaleService {
	public WholesaleOrder createWholesaleOrder(WholesaleOrder wOrder)throws Exception;
	public boolean createWholesaleItems(WholesaleItem wItem) throws Exception;
	public boolean payWholesaleOrder(String wOrderCode, String username)throws Exception;
	//public List<WholesaleOrder> selectWholesaleOrderByCustomer(String username)throws Exception;
	public Object listByCondition(Map<String, Object> args);
	public Object listCancelByCondition(Map<String, Object> args);
	public Object listWMoneyIOByCondition(Map<String, Object> args);
	public Object listWholeItemByCondition(Map<String, Object> args);
	public boolean wholesaleOutApply(String wholesasleOrdCode)throws Exception;
	
}
