package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.SellPrice;
import com.ncu.clothwholesale.pojo.SellPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellPriceMapper {
    int countByExample(SellPriceExample example);

    int deleteByExample(SellPriceExample example);

    int deleteByPrimaryKey(String sellPriceCode);

    int insert(SellPrice record);

    int insertSelective(SellPrice record);

    List<SellPrice> selectByExample(SellPriceExample example);

    SellPrice selectByPrimaryKey(String sellPriceCode);

    int updateByExampleSelective(@Param("record") SellPrice record, @Param("example") SellPriceExample example);

    int updateByExample(@Param("record") SellPrice record, @Param("example") SellPriceExample example);

    int updateByPrimaryKeySelective(SellPrice record);

    int updateByPrimaryKey(SellPrice record);
}