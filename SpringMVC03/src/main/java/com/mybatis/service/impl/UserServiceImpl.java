package com.mybatis.service.impl;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/4/24 0024.
 */
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
