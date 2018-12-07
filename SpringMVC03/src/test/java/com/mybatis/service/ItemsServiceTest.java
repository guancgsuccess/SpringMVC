package com.mybatis.service;

import com.mybatis.pojo.ItemsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/12 0012.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class ItemsServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private ItemsService itemsService;

    @Test
    public void testFindItemsById() throws Exception {
        ItemsCustom itemsCustom = itemsService.findItemsById(1L);
        System.out.println(itemsCustom);
    }

    @Test
    public void testUpdateItems() throws Exception {
        ItemsCustom itemsCustom = itemsService.findItemsById(1L);
        itemsCustom.setCreatetime(new Date());
        itemsService.updateItems(1L,itemsCustom);
    }

    @Test
    public void testSaveItemsList() throws Exception{
        for (int i = 4; i <=10; i++) {
            ItemsCustom itemsCustom = new ItemsCustom();
            itemsCustom.setId(Long.valueOf(i));
            itemsCustom.setName("苹果手机");
            itemsCustom.setPrice(6000.0);
            itemsCustom.setDetail("装逼手机!");
            itemsCustom.setCreatetime(new Date());
            itemsService.saveItemsList(itemsCustom);
        }
    }
}
