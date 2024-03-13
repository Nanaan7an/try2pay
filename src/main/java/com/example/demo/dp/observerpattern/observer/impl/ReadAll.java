package com.example.demo.dp.observerpattern.observer.impl;

import com.example.demo.dp.observerpattern.display.Speak;
import com.example.demo.dp.observerpattern.observer.Observer;
import com.example.demo.dp.observerpattern.subject.impl.JumpMagazine;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Nanaan
 * @Date 2024/2/20 14:08
 * @Description 会读取所有更新内容的读者类
 */
@Slf4j
public class ReadAll implements Observer, Speak {

    private JumpMagazine jumpMagazine;

    /**
     * @Date 2024/2/20 14:41
     * @Description 重写构造方法，将subject实例对象显式注册为观察者
     */
    public ReadAll(JumpMagazine jumpMagazine) {
        this.jumpMagazine = jumpMagazine;
        jumpMagazine.register(this);
    }

    /**
    * @Date 2024/2/27 18:57
    * @Description
    */
    @Override
    public void update() {
        letSpeak();
    }

    @Override
    public void letSpeak() {
        log.info("ALL");
    }
}
