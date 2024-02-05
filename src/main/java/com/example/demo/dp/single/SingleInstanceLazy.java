package com.example.demo.dp.single;

/**
 * 懒汉式，在首次使用对象的时候，才去创建对象，延迟创建对象
 */
public class SingleInstanceLazy {
    /**
     * 私有化构造方法，避免其他类创建该类的实例
     */
    private SingleInstanceLazy(){}

    /**
     * 1.声明变量，并未赋值
     */
    private static SingleInstanceLazy instance;
    

    /**
     * 对外提供访问方式
     * 使用该方法时，若已存在实例，则直接返回该实例；若未创建实例，则创建并返回。
     * 多线程下线程不安全，会创建多个实例。
     * @return 实例
     */
    public static SingleInstanceLazy getInstance() {
        if (instance == null) {
            instance = new SingleInstanceLazy();
        }
        return instance;
    }
}