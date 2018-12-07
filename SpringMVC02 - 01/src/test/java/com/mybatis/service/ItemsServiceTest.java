package com.mybatis.service;

import com.mybatis.pojo.ItemsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/12 0012.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml","classpath:mybatis/*.xml"})
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
}
