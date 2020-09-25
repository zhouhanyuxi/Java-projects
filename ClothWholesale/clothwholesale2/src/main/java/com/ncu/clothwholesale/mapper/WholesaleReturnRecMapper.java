package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.WholesaleReturnRec;
import com.ncu.clothwholesale.pojo.WholesaleReturnRecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WholesaleReturnRecMapper {
    int countByExample(WholesaleReturnRecExample example);

    int deleteByExample(WholesaleReturnRecExample example);

    int deleteByPrimaryKey(Long returnRecNum);

    int insert(WholesaleReturnRec record);

    int insertSelective(WholesaleReturnRec record);

    List<WholesaleReturnRec> selectByExample(WholesaleReturnRecExample example);

    WholesaleReturnRec selectByPrimaryKey(Long returnRecNum);

    int updateByExampleSelective(@Param("record") WholesaleReturnRec record, @Param("example") WholesaleReturnRecExample example);

    int updateByExample(@Param("record") WholesaleReturnRec record, @Param("example") WholesaleReturnRecExample example);

    int updateByPrimaryKeySelective(WholesaleReturnRec record);

    int updateByPrimaryKey(WholesaleReturnRec record);
}