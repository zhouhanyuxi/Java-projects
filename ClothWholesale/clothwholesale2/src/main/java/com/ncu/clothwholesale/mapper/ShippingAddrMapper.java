package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.ShippingAddr;
import com.ncu.clothwholesale.pojo.ShippingAddrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingAddrMapper {
    int countByExample(ShippingAddrExample example);

    int deleteByExample(ShippingAddrExample example);

    int deleteByPrimaryKey(Long shippingAddrNum);

    int insert(ShippingAddr record);

    int insertSelective(ShippingAddr record);

    List<ShippingAddr> selectByExample(ShippingAddrExample example);

    ShippingAddr selectByPrimaryKey(Long shippingAddrNum);

    int updateByExampleSelective(@Param("record") ShippingAddr record, @Param("example") ShippingAddrExample example);

    int updateByExample(@Param("record") ShippingAddr record, @Param("example") ShippingAddrExample example);

    int updateByPrimaryKeySelective(ShippingAddr record);

    int updateByPrimaryKey(ShippingAddr record);
}