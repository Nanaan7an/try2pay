package com.example.demo.dp.observerpattern.observer;

/**
 * @Author Nanaan
 * @Date 2024/2/20 14:08
 * @Description 观察者
 */
public interface Observer {

    /**
     * 当主题的内容发生变化时，观察者获得这些内容；
     * 所有观察者继承这个类，所以必须实现这个方法，从而可以获得主题的内容。
     */
    void update();

}
