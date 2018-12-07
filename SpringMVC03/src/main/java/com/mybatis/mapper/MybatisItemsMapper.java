package com.mybatis.mapper;

import com.mybatis.pojo.MybatisItems;
import com.mybatis.pojo.MybatisItemsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MybatisItemsMapper {
    int countByExample(MybatisItemsExample example);

    int deleteByExample(MybatisItemsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MybatisItems record);

    int insertSelective(MybatisItems record);

    List<MybatisItems> selectByExample(MybatisItemsExample example);

    MybatisItems selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MybatisItems record, @Param("example") MybatisItemsExample example);

    int updateByExample(@Param("record") MybatisItems record, @Param("example") MybatisItemsExample example);

    int updateByPrimaryKeySelective(MybatisItems record);

    int updateByPrimaryKey(MybatisItems record);
}