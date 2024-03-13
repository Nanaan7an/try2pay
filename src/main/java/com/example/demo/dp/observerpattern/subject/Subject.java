package com.example.demo.dp.observerpattern.subject;

import com.example.demo.dp.observerpattern.observer.Observer;

/**
 * @Author Nanaan
 * @Date 2024/2/20 14:05
 * @Description 主题subject
 */
public interface Subject {
    /**
    * @Date 2024/2/22 10:36
    * @Description 注册订阅者
    * @param observer
    * @return
    */
    void register(Observer observer);

    /*
    移除订阅者
     */
    void remove(Observer observer);

    /*
    通知订阅者
     */
    void notifyReader();
}
