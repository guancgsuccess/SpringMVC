package com.mybatis.mapper;

import com.mybatis.pojo.MybatisUser;
import com.mybatis.pojo.MybatisUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MybatisUserMapper {
    int countByExample(MybatisUserExample example);

    int deleteByExample(MybatisUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MybatisUser record);

    int insertSelective(MybatisUser record);

    List<MybatisUser> selectByExample(MybatisUserExample example);

    MybatisUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MybatisUser record, @Param("example") MybatisUserExample example);

    int updateByExample(@Param("record") MybatisUser record, @Param("example") MybatisUserExample example);

    int updateByPrimaryKeySelective(MybatisUser record);

    int updateByPrimaryKey(MybatisUser record);
}