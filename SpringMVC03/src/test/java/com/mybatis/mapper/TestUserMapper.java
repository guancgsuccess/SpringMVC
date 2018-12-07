package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/24 0024.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml","classpath:mybatis/*.xml"})
@WebAppConfiguration
public class TestUserMapper extends AbstractTestNGSpringContextTests{
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindUserByName(){
        System.out.println(userMapper);
        User u = userMapper.findByUsername("管成功");
        System.out.println(u);
    }

}
