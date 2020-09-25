package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.WholesaleExchangeRec;
import com.ncu.clothwholesale.pojo.WholesaleExchangeRecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WholesaleExchangeRecMapper {
    int countByExample(WholesaleExchangeRecExample example);

    int deleteByExample(WholesaleExchangeRecExample example);

    int deleteByPrimaryKey(Long exchangeRecNum);

    int insert(WholesaleExchangeRec record);

    int insertSelective(WholesaleExchangeRec record);

    List<WholesaleExchangeRec> selectByExample(WholesaleExchangeRecExample example);

    WholesaleExchangeRec selectByPrimaryKey(Long exchangeRecNum);

    int updateByExampleSelective(@Param("record") WholesaleExchangeRec record, @Param("example") WholesaleExchangeRecExample example);

    int updateByExample(@Param("record") WholesaleExchangeRec record, @Param("example") WholesaleExchangeRecExample example);

    int updateByPrimaryKeySelective(WholesaleExchangeRec record);

    int updateByPrimaryKey(WholesaleExchangeRec record);
}