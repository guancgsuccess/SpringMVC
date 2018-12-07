package com.mybatis.controller;

import com.mybatis.pojo.MybatisItems;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 使用注解开发...
 * Created by Administrator on 2017/4/7 0007.\
 * 使用注解的映射器和注解的适配器(必须配对使用)
 *
 */
//使用该注解标识它是一个控制器
@Controller
public class ItemsController3 {
    //商品查询
    //该注解实现对queryItem方法和url进行映射,一个方法对应一个url
    //一般建议将url和方法写成一样
    @RequestMapping("/queryItemsList")
    public ModelAndView queryItems() throws Exception{
        // 调用service查找数据库,查询商品列表,这里使用静态数据模拟...

        // 调用service查找 数据库，查询商品列表，这里使用静态数据模拟
        List<MybatisItems> itemsList = new ArrayList<>();
        // 向list中填充静态数据

        MybatisItems items_1 = new MybatisItems();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000d);
        items_1.setCreatetime(new Date());
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        MybatisItems items_2 = new MybatisItems();
        items_2.setName("苹果手机");
        items_2.setPrice(5000d);
        items_2.setCreatetime(new Date());
        items_2.setDetail("iphone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);
        //指定视图...如果视图解析器配置了前缀和后缀的话

        modelAndView.setViewName("items/index");
        return modelAndView;
    }

    //可以定义其他的方法...
    //商品添加...
}
