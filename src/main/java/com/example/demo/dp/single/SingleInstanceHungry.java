package com.example.demo.dp.single;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.example.demo.common.util.DateUtil.getDateTime;

/**
 * 饿汉式，需要获取对象的时候，对象已经提前创建。
 * 对象会一直存在内存中，不使用也仍然存在，造成浪费内存
 */
@Slf4j
public class SingleInstanceHungry {
    /**
     * 构造器私有化，避免外部方法创建该类的对象
     */
    private SingleInstanceHungry() {
    }

    /**
     * 1.静态成员变量方式
     * 创建一个对象供其他使用
     */
    private static SingleInstanceHungry instance = new SingleInstanceHungry();

    /**
     * 2.静态代码块方式
     * 在静态代码块中赋值
     */
//    private static SingleInstanceHungry instance2;
//    static {
//        instance2 = new SingleInstanceHungry();
//    }

    /**
     * 外部可访问的方法，使得外部类可以获取实例对象
     *
     * @return 单例对象
     */
    public static SingleInstanceHungry getInstance() {
        log.info("[{}]创建SingleInstanceHungry", getDateTime());
        return instance;
    }

}
