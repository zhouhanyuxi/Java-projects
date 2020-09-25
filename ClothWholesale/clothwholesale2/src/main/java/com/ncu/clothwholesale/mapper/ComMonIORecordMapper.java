package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.ComMonIORecord;
import com.ncu.clothwholesale.pojo.ComMonIORecordExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ComMonIORecordMapper {
    int countByExample(ComMonIORecordExample example);

    int deleteByExample(ComMonIORecordExample example);

    int deleteByPrimaryKey(String comIORecCode);

    int insert(ComMonIORecord record);

    int insertSelective(ComMonIORecord record);

    List<ComMonIORecord> selectByExample(ComMonIORecordExample example);

    ComMonIORecord selectByPrimaryKey(String comIORecCode);

    int updateByExampleSelective(@Param("record") ComMonIORecord record, @Param("example") ComMonIORecordExample example);

    int updateByExample(@Param("record") ComMonIORecord record, @Param("example") ComMonIORecordExample example);

    int updateByPrimaryKeySelective(ComMonIORecord record);

    int updateByPrimaryKey(ComMonIORecord record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}