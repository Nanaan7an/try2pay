package com.example.demo.frame.generic.method;

import com.example.demo.frame.generic.entity.Drink;

/**
 * @Author Nanaan
 * @Date 2024/6/23 0:18
 * @Description 代理类，代替Market制作商品
 */

public class Agent {
    /**
     *
     * @param drink
     * @param market 商店
     *               super，下界通配符，限定下界，使得？可以捕获下界类型及其超类
     */
    public void serve(Drink drink, Market<? super Drink> market) {
        market.makeGoods(drink);
    }
}
