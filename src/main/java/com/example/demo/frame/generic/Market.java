package com.example.demo.frame.generic;

import com.example.demo.frame.generic.entity.Goods;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Nanaan
 * @Date 2024/6/5 17:27
 * @Description 商铺类。
 * 使用构造方法创建一个新店铺。
 * 店铺中可以制作、出售商品；当商品存在质量问题，也能被退回。
 * <T extends Goods>：在继承关系中，extends限制了泛型类的上限，即Market可以接受的类是Goods及其子类。
 * <T extends GoodsChange>：Market可以接受的类是实现了接口的类吗，表示只接受开商品会发生变化的店铺。
 * 若不限制泛型上界，则默认上界为Object，即可以接受所有的类。
 */

@Slf4j
@Data
public class Market<T extends Goods> {

    public Market() {
        log.info("创建了一个新店铺！");
    }

    /**
     * 制作商品
     *
     * @return 制作好的商品
     */
    public void makeGoods(T t, String date, String area) {
        t.setDate(date);
        t.setArea(area);
        log.info("制作了一个[{}]，生产日期：[{}]，产地：[{}]", t.getClass().getName(), t.getDate(), t.getArea());
    }

    /**
     * 出售商品
     *
     * @param t
     */
    public void saleGoods(T t) {
        log.info("出售了一个[{}]", t.getClass());
    }

    /**
     * 商品被退货
     *
     * @return 商品
     */
    public void returnGoods(T t) {
        log.info("退钱！");
    }

    /**
     * 换货。
     * 这是一个泛型方法，其类型参数P不能在其他地方使用，如不能识别为一个参数，不能在其他方法中使用等。
     *
     * @param p   原来的物品
     * @param <P>
     * @return 新物品
     */
    public <P> P exchangeGood(P p) {
        log.info("换了另一个商品{}", p.getClass());
        return p;
    }
}
