package com.example.demo.frame.generic.entity;

import com.example.demo.frame.generic.GoodsChange;
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
     * 净含量
     */
    private String net;

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
