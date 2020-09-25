package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.WholesaleCancelRec;
import com.ncu.clothwholesale.pojo.WholesaleCancelRecExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WholesaleCancelRecMapper {
    int countByExample(WholesaleCancelRecExample example);

    int deleteByExample(WholesaleCancelRecExample example);

    int deleteByPrimaryKey(Long cancelRecNum);

    int insert(WholesaleCancelRec record);

    int insertSelective(WholesaleCancelRec record);

    List<WholesaleCancelRec> selectByExample(WholesaleCancelRecExample example);

    WholesaleCancelRec selectByPrimaryKey(Long cancelRecNum);

    int updateByExampleSelective(@Param("record") WholesaleCancelRec record, @Param("example") WholesaleCancelRecExample example);

    int updateByExample(@Param("record") WholesaleCancelRec record, @Param("example") WholesaleCancelRecExample example);

    int updateByPrimaryKeySelective(WholesaleCancelRec record);

    int updateByPrimaryKey(WholesaleCancelRec record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}