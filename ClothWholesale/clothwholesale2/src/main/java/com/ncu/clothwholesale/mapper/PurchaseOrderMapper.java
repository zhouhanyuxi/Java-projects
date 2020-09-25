package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.PurchaseOrder;
import com.ncu.clothwholesale.pojo.PurchaseOrderExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

public interface PurchaseOrderMapper {
    int countByExample(PurchaseOrderExample example);

    int deleteByExample(PurchaseOrderExample example);

    int deleteByPrimaryKey(String purchaseOrdCode);

    int insert(PurchaseOrder record);

    int insertSelective(PurchaseOrder record);

    List<PurchaseOrder> selectByExample(PurchaseOrderExample example);

    PurchaseOrder selectByPrimaryKey(String purchaseOrdCode);

    int updateByExampleSelective(@Param("record") PurchaseOrder record, @Param("example") PurchaseOrderExample example);

    int updateByExample(@Param("record") PurchaseOrder record, @Param("example") PurchaseOrderExample example);

    int updateByPrimaryKeySelective(PurchaseOrder record);

    int updateByPrimaryKey(PurchaseOrder record);

	int updatePurcOrdSumPrice(@Param("pOrdCode")String purchaseOrdCode, @Param("price")Double totalprice);

	int updatePurcOrdPaidPrice(@Param("pOrdCode")String purchaseOrdCode, @Param("price")Double totalPrice);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);

}