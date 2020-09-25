package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.OrderMonRec;
import com.ncu.clothwholesale.pojo.OrderMonRecExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderMonRecMapper {
    int countByExample(OrderMonRecExample example);

    int deleteByExample(OrderMonRecExample example);

    int deleteByPrimaryKey(String ordMonRecCode);

    int insert(OrderMonRec record);

    int insertSelective(OrderMonRec record);

    List<OrderMonRec> selectByExample(OrderMonRecExample example);

    OrderMonRec selectByPrimaryKey(String ordMonRecCode);

    int updateByExampleSelective(@Param("record") OrderMonRec record, @Param("example") OrderMonRecExample example);

    int updateByExample(@Param("record") OrderMonRec record, @Param("example") OrderMonRecExample example);

    int updateByPrimaryKeySelective(OrderMonRec record);

    int updateByPrimaryKey(OrderMonRec record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}