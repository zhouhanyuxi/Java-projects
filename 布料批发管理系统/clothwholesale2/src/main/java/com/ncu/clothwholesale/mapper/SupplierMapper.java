package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.Supplier;
import com.ncu.clothwholesale.pojo.SupplierExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
    int countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(String supplierCode);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(String supplierCode);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}