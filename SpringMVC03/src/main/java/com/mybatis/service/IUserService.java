package com.mybatis.service;

import com.mybatis.pojo.User;

/**
 * Created by Administrator on 2017/4/24 0024.
 */
public interface IUserService {
    /**
     *根据用户名查询用户
     * @param username
     * @return User
     */
    User findByUsername(String username);
}
