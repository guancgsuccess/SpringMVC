package com.mybatis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.pojo.MybatisItems;
import org.springframework.web.HttpRequestHandler;


/**
 * 实现controller接口的处理器
 * 
 * @author Administrator
 *
 */
public class ItemsController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		req.setAttribute("itemsList", itemsList);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		//使用此方法可以通过修改response,设置响应的数据格式,比如响应json数据.
	}
}
