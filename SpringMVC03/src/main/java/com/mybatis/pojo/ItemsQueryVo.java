package com.mybatis.pojo;

import java.util.List;

/**
 * 商品包装对象
 * Created by Administrator on 2017/4/9 0009.
 */
public class ItemsQueryVo {
    //商品信息
    private MybatisItems items;

    //为了系统可扩展性,对原始生成的po进行拓展
    private ItemsCustom itemsCustom;

    //批量商品信息
    private List<ItemsCustom> itemsList;

    public void setItems(MybatisItems items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public MybatisItems getItems() {
        return items;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }

    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }
}
