package com.ncu.clothwholesale.mapper;

import com.ncu.clothwholesale.pojo.Admin;
import com.ncu.clothwholesale.pojo.AdminExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(String adminCode);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(String adminCode);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

	List<Map<String, Object>> listByCondition(Map<String, Object> args);
}