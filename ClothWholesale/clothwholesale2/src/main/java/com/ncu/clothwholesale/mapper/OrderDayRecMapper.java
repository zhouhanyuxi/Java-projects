package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.OrderDayRec;
import com.ncu.clothwholesale.pojo.OrderDayRecExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderDayRecMapper {
    int countByExample(OrderDayRecExample example);

    int deleteByExample(OrderDayRecExample example);

    int deleteByPrimaryKey(String ordDayRecCode);

    int insert(OrderDayRec record);

    int insertSelective(OrderDayRec record);

    List<OrderDayRec> selectByExample(OrderDayRecExample example);

    OrderDayRec selectByPrimaryKey(String ordDayRecCode);

    int updateByExampleSelective(@Param("record") OrderDayRec record, @Param("example") OrderDayRecExample example);

    int updateByExample(@Param("record") OrderDayRec record, @Param("example") OrderDayRecExample example);

    int updateByPrimaryKeySelective(OrderDayRec record);

    int updateByPrimaryKey(OrderDayRec record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}