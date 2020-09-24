package com.ncu.clothwholesale.service;


import java.util.List;
import java.util.Map;

import com.ncu.clothwholesale.dto.WarehouseIORecSearch;
import com.ncu.clothwholesale.pojo.WarehouseIORecord;

public interface InventoryService {
	public boolean createIORecord(WarehouseIORecord warehouseIORecord)throws Exception;
	//public boolean createPurcItemWarehouseIORec(WarehouseIORecord warehouseIORecord)throws Exception;
	//public boolean createWholesaleOrderIORec(WarehouseIORecord warehouseIORecord)throws Exception;
	public List<WarehouseIORecord> findWarehouseIORec(WarehouseIORecSearch search)throws Exception;
	public Object listByCondition(Map<String, Object> args);
	public Object listIOByCondition(Map<String, Object> args);
	public boolean putPurchaseItemIn(String warehouseCode, String purchaseItemCode, String adminCode)throws Exception;
	public String putWholesaleItemOut(String wholesaleItemCode,String adminCode) throws Exception;
}
