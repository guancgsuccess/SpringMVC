package com.mybatis.pojo;

public class MybatisOrderdetail {
    private Long id;

    private Long ordersId;

    private Long itemsId;

    private Long itemsNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    public Long getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Long itemsNum) {
        this.itemsNum = itemsNum;
    }
}