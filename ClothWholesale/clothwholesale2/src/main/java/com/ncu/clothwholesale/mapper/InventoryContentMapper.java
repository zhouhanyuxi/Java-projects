package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.InventoryContent;
import com.ncu.clothwholesale.pojo.InventoryContentExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InventoryContentMapper {
    int countByExample(InventoryContentExample example);

    int deleteByExample(InventoryContentExample example);

    int deleteByPrimaryKey(Long inventoryContInd);

    int insert(InventoryContent record);

    int insertSelective(InventoryContent record);

    List<InventoryContent> selectByExample(InventoryContentExample example);

    InventoryContent selectByPrimaryKey(Long inventoryContInd);

    int updateByExampleSelective(@Param("record") InventoryContent record, @Param("example") InventoryContentExample example);

    int updateByExample(@Param("record") InventoryContent record, @Param("example") InventoryContentExample example);

    int updateByPrimaryKeySelective(InventoryContent record);

    int updateByPrimaryKey(InventoryContent record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}