package com.mybatis.mapper;

import com.mybatis.pojo.ItemsCustom;
import com.mybatis.pojo.ItemsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml","classpath:mybatis/*.xml"})
public class TestItemsMapperCustom extends AbstractTestNGSpringContextTests{
    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Test
    public void testFindItemsList() throws Exception {
        ItemsQueryVo vo = new ItemsQueryVo();
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName("2");
        vo.setItemsCustom(itemsCustom);
        List<ItemsCustom> list = itemsMapperCustom.findItemsList(vo);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}
