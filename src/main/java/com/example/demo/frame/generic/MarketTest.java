package com.example.demo.frame.generic;

import com.example.demo.frame.generic.entity.Dessert;
import com.example.demo.frame.generic.entity.Drink;

/**
 * @Author Nanaan
 * @Date 2024/6/5 17:28
 * @Description 测试类
 */

public class MarketTest {
    public static void main(String[] args) {
        /**
         * 开了一个饮品店drinkMarket
         */
        Market<Drink> drinkMarket = new Market<>();
        //-研发了一款饮品milkTea
        Drink milkTea = new Drink();
        //-制作并售出了这个饮品
        drinkMarket.makeGoods(milkTea, "2024", "ab");
        drinkMarket.saleGoods(milkTea);
        //-这个饮品被退回了
        drinkMarket.returnGoods(milkTea);
        Drink exDrink = drinkMarket.exchangeGood(milkTea);

        System.out.println("=======================");
        /**
         * 开了一个甜品店
         */
        Market<Dessert> dessertMarket = new Market<>();
        //-研发了一款甜品cake
        Dessert cake = new Dessert();
        //-制作并售出了这个甜品
        dessertMarket.makeGoods(cake, "2024", "sh");
        dessertMarket.saleGoods(cake);
        dessertMarket.returnGoods(cake);

        /**
         * 开了一个人口贩卖店铺，显然不合法，应当禁止开张。
         * 在Market中已经做了限制，此处的店铺被禁止开业
         */
//        Market<Human> humanMarket=new Market<>();
    }
}
