package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.ProductModel;
import com.ncu.clothwholesale.pojo.ProductModelExample;
import com.ncu.clothwholesale.vo.ModelSaleInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductModelMapper {
    int countByExample(ProductModelExample example);

    int deleteByExample(ProductModelExample example);

    int deleteByPrimaryKey(String modelCode);

    int insert(ProductModel record);

    int insertSelective(ProductModel record);

    List<ProductModel> selectByExample(ProductModelExample example);

    ProductModel selectByPrimaryKey(String modelCode);

    int updateByExampleSelective(@Param("record") ProductModel record, @Param("example") ProductModelExample example);

    int updateByExample(@Param("record") ProductModel record, @Param("example") ProductModelExample example);

    int updateByPrimaryKeySelective(ProductModel record);

    int updateByPrimaryKey(ProductModel record);

	ModelSaleInfo findModelSaleInfoById(@Param("modelCode")String modelCode);
}