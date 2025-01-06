package com.example.demo.frame.generic;

import com.example.demo.frame.generic.entity.Dessert;
import com.example.demo.frame.generic.entity.Drink;
import com.example.demo.frame.generic.entity.Goods;
import com.example.demo.frame.generic.method.Agent;
import com.example.demo.frame.generic.method.Management;
import com.example.demo.frame.generic.method.Market;

/**
 * @Author Nanaan
 * @Date 2024/6/5 17:28
 * @Description 测试类
 */

public class GenericTest {
    public static void main(String[] args) {
        /**
         * 颁发许可证
         */
        Management management = new Management();

        /**
         * 开了一个饮品店drinkMarket
         */
        Market<Drink> drinkMarket = new Market<>();
        //获得许可证
        management.beAllowed(drinkMarket);
        //获得了饮品milkTea
        Drink milkTea = new Drink("milkTea");
        //上架饮品
        drinkMarket.makeGoods(milkTea);
        drinkMarket.makeGoods(new Drink("milkTea222", 200));
        //查看库存
        System.out.println("看看库存" + drinkMarket.haveGoods());
        milkTea.shake();
        milkTea.evaporate();
        //售出饮品
        drinkMarket.saleGoods(milkTea);
        //打包物品
        Drink packageDrink = drinkMarket.packageGood(milkTea);
        //有一个代工厂
        Agent agent = new Agent();
        //代工厂代理做饮品
        agent.serve(milkTea, drinkMarket);

        System.out.println("=======================");
        /**
         * 开了一个甜品店
         */
        Market<Dessert> dessertMarket = new Market<>();
        //-获得了甜品cake
        Dessert cake = new Dessert();
        //-制作并售出了这个甜品
        dessertMarket.makeGoods(cake);
        dessertMarket.saleGoods(cake);
        //代工厂做甜品报错，证明super生效
//        agent.serve(cake,dessertMarket);

        /**
         * 开了一个人口贩卖店铺，显然不合法，应当禁止开张。
         * 在Market中已经做了限制，此处的店铺被禁止开业
         */
//        Market<Human> humanMarket=new Market<>();

        /**
         *开了一个啥也能卖的
         */
        Market<Goods> market = new Market<>();
        management.beAllowed(market);
        //代工厂可以让超类使用
        agent.serve(milkTea, market);
    }
}
