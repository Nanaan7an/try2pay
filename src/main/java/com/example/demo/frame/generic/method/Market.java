package com.example.demo.frame.generic.method;

import com.example.demo.frame.generic.entity.Goods;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

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
    //是否获得许可，默认是没有
    boolean isAllow = false;


    public Market() {
        log.info("创建了一个新店铺！");
        this.goods = new HashSet<>();
    }

    /**
     * 货柜，物品good无序摆放
     */
    private Set<T> goods;

    /**
     * 制作商品
     * setter
     */
    public void makeGoods(T good) {
        log.info("上架{}", good);
        this.goods.add(good);
    }

    /**
     * 出售商品
     * setter
     */
    public void saleGoods(T good) {
        log.info("售出{}", good);
//        if (!this.isAllow){
//            log.info("没有许可，禁止出售！");
//        }else
        this.goods.remove(good);
    }

    /**
     * 返回库存
     * getter
     * @return
     */
    public Set<T> haveGoods() {
        return this.goods;
    }

    /**
     * 打包。
     * 这是一个泛型方法，其类型参数P不能在其他地方使用，如不能识别为一个参数，不能在其他方法中使用等。
     *
     * @param p   原来的物品
     * @param <P>
     * @return 打包后的物品
     */
    public <P> P packageGood(P p) {
        log.info("打包{}", p);
        return p;
    }
}
