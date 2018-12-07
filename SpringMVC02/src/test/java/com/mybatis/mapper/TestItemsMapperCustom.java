package com.mybatis.mapper;

import com.mybatis.pojo.ItemsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@ContextConfiguration(locations = "classpath:spring/springmvc.xml")
public class TestItemsMapperCustom extends AbstractTestNGSpringContextTests{
    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Test
    public void testFindItemsList() throws Exception {
        List<ItemsCustom> list = itemsMapperCustom.findItemsList(null);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}
