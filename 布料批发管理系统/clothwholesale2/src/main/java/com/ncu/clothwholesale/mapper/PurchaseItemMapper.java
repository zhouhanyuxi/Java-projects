package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.PurchaseItem;
import com.ncu.clothwholesale.pojo.PurchaseItemExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PurchaseItemMapper {
    int countByExample(PurchaseItemExample example);

    int deleteByExample(PurchaseItemExample example);

    int deleteByPrimaryKey(String purchaseItemCode);

    int insert(PurchaseItem record);

    int insertSelective(PurchaseItem record);

    List<PurchaseItem> selectByExample(PurchaseItemExample example);

    PurchaseItem selectByPrimaryKey(String purchaseItemCode);

    int updateByExampleSelective(@Param("record") PurchaseItem record, @Param("example") PurchaseItemExample example);

    int updateByExample(@Param("record") PurchaseItem record, @Param("example") PurchaseItemExample example);

    int updateByPrimaryKeySelective(PurchaseItem record);

    int updateByPrimaryKey(PurchaseItem record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}