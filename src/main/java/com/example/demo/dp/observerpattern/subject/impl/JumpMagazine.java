package com.example.demo.dp.observerpattern.subject.impl;

import com.example.demo.dp.observerpattern.observer.Observer;
import com.example.demo.dp.observerpattern.subject.Subject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Nanaan
 * @Date 2024/2/20 14:09
 * @Description 主题实现类
 */
@Slf4j
public class JumpMagazine implements Subject {

    /**
     * 持有观察者Observer，并在构造器中创建
     */
    private List<Observer> observers;

    /**
     * @Date 2024/2/27 18:40
     * @Description
     */
    public JumpMagazine() {
        observers = new ArrayList<Observer>();
    }

    /**
     * @param observer 读者实例
     * @Date 2024/2/20 14:24
     * @Description 注册观察者时，将添加到列表末端
     * 调用此方法，可以随时注册一个读者，并在后续接收主题更新的消息
     */
    @Override
    public void register(Observer observer) {
        log.info("新读者！");
        observers.add(observer);
    }

    /**
     * @param observer 读者实例
     * @Date 2024/2/20 14:28
     * @Description 取消注册时，从列表中移除
     * 调用此方法，可以随时移除一个读者，在后续不再接收主题更新的消息
     */
    @Override
    public void remove(Observer observer) {
        log.info("取消订阅！");
        observers.remove(observer);
    }

    /**
     * @Date 2024/2/20 14:33
     * @Description 通知方法
     */
    @Override
    public void notifyReader() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * @Date 2024/2/27 18:42
     * @Description 获得更新数据时，将调用通知方法，以通知所有观察者
     */
    public void publish() {
        notifyReader();
    }


    /**
     * 模拟数据，仅为了测试用
     */
    private String one;
    private String two;
    private String three;

//    public void set
}
