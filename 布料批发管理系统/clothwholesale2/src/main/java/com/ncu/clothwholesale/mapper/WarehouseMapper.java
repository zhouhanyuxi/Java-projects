package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.Warehouse;
import com.ncu.clothwholesale.pojo.WarehouseExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WarehouseMapper {
    int countByExample(WarehouseExample example);

    int deleteByExample(WarehouseExample example);

    int deleteByPrimaryKey(String warehouseCode);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    List<Warehouse> selectByExample(WarehouseExample example);

    Warehouse selectByPrimaryKey(String warehouseCode);

    int updateByExampleSelective(@Param("record") Warehouse record, @Param("example") WarehouseExample example);

    int updateByExample(@Param("record") Warehouse record, @Param("example") WarehouseExample example);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}