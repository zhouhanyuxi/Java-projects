package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.CusMonIORec;
import com.ncu.clothwholesale.pojo.CusMonIORecExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CusMonIORecMapper {
    int countByExample(CusMonIORecExample example);

    int deleteByExample(CusMonIORecExample example);

    int deleteByPrimaryKey(String cusMonIORecCode);

    int insert(CusMonIORec record);

    int insertSelective(CusMonIORec record);

    List<CusMonIORec> selectByExample(CusMonIORecExample example);

    CusMonIORec selectByPrimaryKey(String cusMonIORecCode);

    int updateByExampleSelective(@Param("record") CusMonIORec record, @Param("example") CusMonIORecExample example);

    int updateByExample(@Param("record") CusMonIORec record, @Param("example") CusMonIORecExample example);

    int updateByPrimaryKeySelective(CusMonIORec record);

    int updateByPrimaryKey(CusMonIORec record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}