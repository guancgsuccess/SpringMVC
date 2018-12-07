package com.mybatis.pojo;

/**
 * 商品包装对象
 * Created by Administrator on 2017/4/9 0009.
 */
public class ItemsQueryVo {
    //商品信息
    private MybatisItems items;

    //为了系统可扩展性,对原始生成的po进行拓展
    private ItemsCustom itemsCustom;
}
