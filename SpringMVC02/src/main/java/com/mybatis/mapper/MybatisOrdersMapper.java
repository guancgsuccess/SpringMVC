package com.mybatis.mapper;

import com.mybatis.pojo.MybatisOrders;
import com.mybatis.pojo.MybatisOrdersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MybatisOrdersMapper {
    int countByExample(MybatisOrdersExample example);

    int deleteByExample(MybatisOrdersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MybatisOrders record);

    int insertSelective(MybatisOrders record);

    List<MybatisOrders> selectByExample(MybatisOrdersExample example);

    MybatisOrders selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MybatisOrders record, @Param("example") MybatisOrdersExample example);

    int updateByExample(@Param("record") MybatisOrders record, @Param("example") MybatisOrdersExample example);

    int updateByPrimaryKeySelective(MybatisOrders record);

    int updateByPrimaryKey(MybatisOrders record);
}