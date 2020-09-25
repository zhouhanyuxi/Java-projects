package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.WarehouseIORecord;
import com.ncu.clothwholesale.pojo.WarehouseIORecordExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WarehouseIORecordMapper {
    int countByExample(WarehouseIORecordExample example);

    int deleteByExample(WarehouseIORecordExample example);

    int deleteByPrimaryKey(String warehouseIORecCode);

    int insert(WarehouseIORecord record);

    int insertSelective(WarehouseIORecord record);

    List<WarehouseIORecord> selectByExample(WarehouseIORecordExample example);

    WarehouseIORecord selectByPrimaryKey(String warehouseIORecCode);

    int updateByExampleSelective(@Param("record") WarehouseIORecord record, @Param("example") WarehouseIORecordExample example);

    int updateByExample(@Param("record") WarehouseIORecord record, @Param("example") WarehouseIORecordExample example);

    int updateByPrimaryKeySelective(WarehouseIORecord record);

    int updateByPrimaryKey(WarehouseIORecord record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}