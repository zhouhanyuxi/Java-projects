package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.Product;
import com.ncu.clothwholesale.pojo.ProductExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productCode);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productCode);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);

	List<Map<String, Object>> listWithPicByCondition(Map<String, Object> args);
}