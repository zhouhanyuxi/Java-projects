package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.WholesaleItem;
import com.ncu.clothwholesale.pojo.WholesaleItemExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WholesaleItemMapper {
    int countByExample(WholesaleItemExample example);

    int deleteByExample(WholesaleItemExample example);

    int deleteByPrimaryKey(String wholesaleItemCode);

    int insert(WholesaleItem record);

    int insertSelective(WholesaleItem record);

    List<WholesaleItem> selectByExample(WholesaleItemExample example);

    WholesaleItem selectByPrimaryKey(String wholesaleItemCode);

    int updateByExampleSelective(@Param("record") WholesaleItem record, @Param("example") WholesaleItemExample example);

    int updateByExample(@Param("record") WholesaleItem record, @Param("example") WholesaleItemExample example);

    int updateByPrimaryKeySelective(WholesaleItem record);

    int updateByPrimaryKey(WholesaleItem record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}