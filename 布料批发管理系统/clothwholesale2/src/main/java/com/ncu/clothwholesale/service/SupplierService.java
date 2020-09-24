package com.ncu.clothwholesale.service;

import java.util.Map;

import com.ncu.clothwholesale.pojo.Supplier;

public interface SupplierService {

	public Object listByCondition(Map<String, Object> args);

	public Supplier findSupplierById(String supplierCode) throws Exception;

}
