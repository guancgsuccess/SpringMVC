package com.mybatis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.pojo.MybatisItems;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 实现controller接口的处理器
 * 
 * @author Administrator
 *
 */
public class ItemsController implements Controller {



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		//指定视图...
		modelAndView.setViewName("/index.jsp");

		return modelAndView;
	}

}
