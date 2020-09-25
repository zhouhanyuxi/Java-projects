package com.ncu.clothwholesale.service;


import java.util.Map;

import com.ncu.clothwholesale.dto.ComMonIORecSearch;
import com.ncu.clothwholesale.dto.PurchaseOrderSearch;
import com.ncu.clothwholesale.pojo.PurchaseItem;
import com.ncu.clothwholesale.pojo.PurchaseOrder;

public interface PurchaseService {
	public PurchaseOrder createPurchaseOrder(PurchaseOrder pOrder);
	public Object findPurchaseOrders(PurchaseOrderSearch pOrderSearch,String adminCode)throws Exception;
	
	public String createPurchaseItem(PurchaseItem pOrder) throws Exception;
	public boolean payForPurchaseItem(String pItemCode,Double price,String adminCode)throws Exception;
	
	public Object findMonOutRecords(ComMonIORecSearch search)throws Exception;
	public Object listByCondition(Map<String, Object> args);
	public Object listPMoneyIOByCondition(Map<String, Object> args);
	public Object listPurcItemByCondition(Map<String, Object> args);
	public boolean purchaseInApply(String pItemCode)throws Exception;
}
