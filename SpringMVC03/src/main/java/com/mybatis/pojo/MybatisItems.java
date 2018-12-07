package com.mybatis.pojo;

import com.mybatis.controller.validation.ValidGroup1;
import com.mybatis.controller.validation.ValidGroup2;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.Date;

public class MybatisItems {
    private Long id;

    //校验名称在2到10字符中间
     //message是提示校验出错显示的信息
     //groups：此校验属于哪个分组，groups可以定义多个分组
    @Size(min = 2,max = 10,message = "{items.name.length.error}",groups = {ValidGroup1.class})
    private String name;

    //非空校验
    @NotBlank(message="{items.detail.isnull.error}",groups = {ValidGroup2.class})
    private String detail;

    private Double price;

    private String pic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "MybatisItems{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", pic='" + pic + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}