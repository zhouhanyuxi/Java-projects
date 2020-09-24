package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.OrderYearRec;
import com.ncu.clothwholesale.pojo.OrderYearRecExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderYearRecMapper {
    int countByExample(OrderYearRecExample example);

    int deleteByExample(OrderYearRecExample example);

    int deleteByPrimaryKey(String ordYearRecCode);

    int insert(OrderYearRec record);

    int insertSelective(OrderYearRec record);

    List<OrderYearRec> selectByExample(OrderYearRecExample example);

    OrderYearRec selectByPrimaryKey(String ordYearRecCode);

    int updateByExampleSelective(@Param("record") OrderYearRec record, @Param("example") OrderYearRecExample example);

    int updateByExample(@Param("record") OrderYearRec record, @Param("example") OrderYearRecExample example);

    int updateByPrimaryKeySelective(OrderYearRec record);

    int updateByPrimaryKey(OrderYearRec record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}