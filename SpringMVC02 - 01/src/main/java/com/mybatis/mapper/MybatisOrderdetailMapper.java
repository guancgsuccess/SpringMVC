package com.mybatis.mapper;

import com.mybatis.pojo.MybatisOrderdetail;
import com.mybatis.pojo.MybatisOrderdetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MybatisOrderdetailMapper {
    int countByExample(MybatisOrderdetailExample example);

    int deleteByExample(MybatisOrderdetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MybatisOrderdetail record);

    int insertSelective(MybatisOrderdetail record);

    List<MybatisOrderdetail> selectByExample(MybatisOrderdetailExample example);

    MybatisOrderdetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MybatisOrderdetail record, @Param("example") MybatisOrderdetailExample example);

    int updateByExample(@Param("record") MybatisOrderdetail record, @Param("example") MybatisOrderdetailExample example);

    int updateByPrimaryKeySelective(MybatisOrderdetail record);

    int updateByPrimaryKey(MybatisOrderdetail record);
}