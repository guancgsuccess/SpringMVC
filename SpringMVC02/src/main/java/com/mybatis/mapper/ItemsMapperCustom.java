package com.mybatis.mapper;

import com.mybatis.pojo.ItemsCustom;
import com.mybatis.pojo.ItemsQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7 0007.
 */
public interface ItemsMapperCustom {
    /**
     * 商品查询列表
     */
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
