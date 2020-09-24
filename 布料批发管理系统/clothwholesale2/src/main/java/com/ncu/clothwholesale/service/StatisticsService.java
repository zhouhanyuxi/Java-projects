package com.ncu.clothwholesale.service;

import java.util.List;
import java.util.Map;

import com.ncu.clothwholesale.pojo.OrderDayRec;
import com.ncu.clothwholesale.pojo.OrderMonRec;
import com.ncu.clothwholesale.pojo.OrderYearRec;
import com.ncu.clothwholesale.tool.BusinessException;

public interface StatisticsService {
	public OrderDayRec createOrderDayRecord(int year, int mon, int day, String type)throws BusinessException;
	public List<OrderMonRec> createOrderMonRecords(int year,int mon)throws BusinessException;
	public List<OrderYearRec> createOrderYearRecords(int year)throws BusinessException;
	public List<OrderYearRec> updateRecords()throws BusinessException;
	public Object listByCondition(Map<String, Object> args);
	public Object listYearByCondition(Map<String, Object> args);
	public Object listMonthByCondition(Map<String, Object> args);
	public Object listDayByCondition(Map<String, Object> args);
}
