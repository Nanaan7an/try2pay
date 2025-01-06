package com.example.demo.frame.generic.entity;

import com.example.demo.frame.generic.method.GoodsChange;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Nanaan
 * @Date 2024/6/5 16:57
 * @Description 饮品类，继承了Goods，表示为可以出售的商品
 */

@Data
@Slf4j
public class Drink extends Goods implements GoodsChange {
    /**
     * 饮品名称
     */
    private String name;

    /**
     * 净含量
     */
    private int net = 100;

    /**
     * 无参构造方法
     */
    public Drink() {
    }

    /**
     * 有参构造方法
     */
    public Drink(String name) {
        this.name = name;
    }

    public Drink(String name, int net) {
        this.name = name;
        this.net = net;
    }


    public void shake(){
        log.info("摇");
    }

    /**
     * 饮品会随时间蒸发
     */
    @Override
    public void evaporate() {
        log.info("蒸发了");
    }
}
