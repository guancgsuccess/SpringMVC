package com.mybatis.service.impl;

import com.mybatis.exception.CustomException;
import com.mybatis.mapper.ItemsMapperCustom;
import com.mybatis.mapper.MybatisItemsMapper;
import com.mybatis.pojo.ItemsCustom;
import com.mybatis.pojo.ItemsQueryVo;
import com.mybatis.pojo.MybatisItems;
import com.mybatis.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10 0010.
 */
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private MybatisItemsMapper mybatisItemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        //通过ItemsMapperCustom查询数据库
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom findItemsById(Long id) throws Exception {

        //根据id查询出items对象
        MybatisItems items = mybatisItemsMapper.selectByPrimaryKey(id);

        if(items==null){
            throw new CustomException("修改商品不存在...");
        }

        //中间对商品信息进行业务处理
        //....
        //返回ItemsCustom
        ItemsCustom itemsCustom = new ItemsCustom();
        //将items的属性值拷贝到itemsCustom
        if(items!=null) {
            BeanUtils.copyProperties(items, itemsCustom);
        }
        return itemsCustom;
    }

    @Override
    public void updateItems(Long id, ItemsCustom itemsCustom) throws Exception {
        //添加业务校验，通常在service接口对关键参数进行校验
        //校验id是否为空，如果为空抛出异常

        //更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
        //updateByPrimaryKeyWithBLOBs要求必须转入id
        itemsCustom.setId(id);
        mybatisItemsMapper.updateByPrimaryKeySelective(itemsCustom);
    }

    @Override
    public void saveItemsList(ItemsCustom itemsCustom) {
        mybatisItemsMapper.insertSelective(itemsCustom);
    }

    @Override
    public void deleteById(Long id) {
        mybatisItemsMapper.deleteByPrimaryKey(id);
    }
}
