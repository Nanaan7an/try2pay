package com.example.demo.frame.generic.entity;

import lombok.Data;

/**
 * @Author Nanaan
 * @Date 2024/6/5 16:55
 * @Description 商品类，可以出售的商品类型均要继承此类。
 * 定义了一些商品的共同属性。
 */
@Data
public class Goods {
    /**
     * 生产日期
     */
    private String date;

    /**
     * 产地
     */
    private String area;

}
