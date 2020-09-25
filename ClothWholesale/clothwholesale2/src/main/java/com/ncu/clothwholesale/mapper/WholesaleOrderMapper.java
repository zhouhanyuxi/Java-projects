package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.WholesaleOrder;
import com.ncu.clothwholesale.pojo.WholesaleOrderExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WholesaleOrderMapper {
    int countByExample(WholesaleOrderExample example);

    int deleteByExample(WholesaleOrderExample example);

    int deleteByPrimaryKey(String wholesaleOrdCode);

    int insert(WholesaleOrder record);

    int insertSelective(WholesaleOrder record);

    List<WholesaleOrder> selectByExample(WholesaleOrderExample example);

    WholesaleOrder selectByPrimaryKey(String wholesaleOrdCode);

    int updateByExampleSelective(@Param("record") WholesaleOrder record, @Param("example") WholesaleOrderExample example);

    int updateByExample(@Param("record") WholesaleOrder record, @Param("example") WholesaleOrderExample example);

    int updateByPrimaryKeySelective(WholesaleOrder record);

    int updateByPrimaryKey(WholesaleOrder record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}