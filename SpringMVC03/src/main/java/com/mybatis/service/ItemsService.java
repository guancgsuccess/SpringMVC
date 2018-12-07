package com.mybatis.service;

import com.mybatis.pojo.ItemsCustom;
import com.mybatis.pojo.ItemsQueryVo;

import java.util.List;

/**
 * 商品管理service
 * Created by Administrator on 2017/4/10 0010.
 */
public interface ItemsService {
    //商品查询列表
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;


    //根据id查询商品信息
    /**
     *
     * <p>Title: findItemsById</p>
     * <p>Description: </p>
     * @param id 查询商品的id
     * @return
     * @throws Exception
     */
    ItemsCustom findItemsById(Long id) throws Exception;

    //修改商品信息
    /**
     *
     * <p>Title: updateItems</p>
     * <p>Description: </p>
     * @param id 修改商品的id
     * @param itemsCustom 修改的商品信息
     * @throws Exception
     */
    void updateItems(Long id, ItemsCustom itemsCustom) throws Exception;

    /**
     * 保存一条商品记录
     * @param
     */
    void saveItemsList(ItemsCustom itemsCustom);

    /**
     * 根据id删除商品记录
     */
    void deleteById(Long id);
}
