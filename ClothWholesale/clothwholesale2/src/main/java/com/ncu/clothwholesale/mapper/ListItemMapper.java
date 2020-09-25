package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.ListItem;
import com.ncu.clothwholesale.pojo.ListItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ListItemMapper {
    int countByExample(ListItemExample example);

    int deleteByExample(ListItemExample example);

    int deleteByPrimaryKey(String listItemCode);

    int insert(ListItem record);

    int insertSelective(ListItem record);

    List<ListItem> selectByExample(ListItemExample example);

    ListItem selectByPrimaryKey(String listItemCode);

    int updateByExampleSelective(@Param("record") ListItem record, @Param("example") ListItemExample example);

    int updateByExample(@Param("record") ListItem record, @Param("example") ListItemExample example);

    int updateByPrimaryKeySelective(ListItem record);

    int updateByPrimaryKey(ListItem record);
}