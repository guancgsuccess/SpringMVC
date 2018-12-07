package com.mybatis.controller;

import com.mybatis.pojo.ItemsCustom;
import com.mybatis.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
@Controller
public class JsonTest {

    @Autowired
    private ItemsService itemsService;

    //请求json串(商品信息)，输出json(商品信息)
    //@RequestBody将请求的商品信息的json串转成itemsCustom对象
    @RequestMapping("/requestJson")
    //@ResponseBody将itemsCustom转成json输出
    public @ResponseBody ItemsCustom requstJson(@RequestBody ItemsCustom itemsCustom){
        System.out.println(itemsCustom);
        return itemsCustom;
    }

    //请求json串(商品信息)，输出json(商品信息)
    //@RequestBody将请求的商品信息的json串转成List<itemsCustom>对象
    @RequestMapping("/requestJsonList")
    //@ResponseBody将List<ItemsCustom>转成json输出
    public @ResponseBody List<ItemsCustom> requstJsonList(@RequestBody List<ItemsCustom> itemsCustom){
        System.out.println(itemsCustom);
        return itemsCustom;
    }

    //请求json串(商品信息)，输出json(商品信息)
    //@RequestBody将请求的商品信息的json串转成itemsCustom对象
    @RequestMapping("/requestJsonStr")
    //@ResponseBody将itemsCustom转成json输出
    public @ResponseBody ItemsCustom requstJsonStr(ItemsCustom itemsCustom){
        System.out.println(itemsCustom);
        return itemsCustom;
    }

    //请求json串(商品信息)，输出json(商品信息)
    //@RequestBody将请求的商品信息的json串转成itemsCustom对象
    @RequestMapping("/findItemsList")
    //@ResponseBody将itemsCustom转成json输出
    public @ResponseBody ItemsCustom requstJsonStr(Long id) throws Exception {
        System.out.println(id);
        return itemsService.findItemsById(id);
    }
}
