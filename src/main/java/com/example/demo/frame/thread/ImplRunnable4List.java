package com.example.demo.frame.thread;

import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.example.demo.common.util.DateUtil.getDateTime2;

/**
 * @Author Nanaan
 * @Date 2024/11/4 9:40
 * @Description 场景：需要给List中的每个元素创建一个线程，执行相应的任务
 */
@Slf4j
public class ImplRunnable4List implements Runnable {
    private Thread t;
    private String threadName;

    /**
     * 使用构造方法创建实现类的实例
     *
     * @param name 实例名称
     */
    ImplRunnable4List(String name) {
        threadName = name;
        log.info("Create obj by Constructor:{}",threadName);
    }

    @Resource
    Mission4List mission4List;

    @Autowired
    UserService userService;

    /**
     * 该方法执行一个线程的相关方法
     */
    @Override
    public void run() {
        try {
            log.info("【{}】->BeginTms【{}】", Thread.currentThread().getName(), getDateTime2());
            int i = Integer.parseInt(Thread.currentThread().getName().replace("Thread", ""));
            log.info("{}的内容{}", i, mission4List.queryUser(i));
        } catch (Exception e) {
            log.error("【{}】:EXCEPTION", Thread.currentThread().getName(), e);
        } finally {
            log.info("【{}】:EXIT->EndTms【{}】", Thread.currentThread().getName(), getDateTime2());
        }
    }

    /**
     * 在使用线程时，只需要使用本类的构造方法创建实例且指定线程名。
     * 调用start()后，本方法会创建一个线程，并使用线程的start()方法启动这个线程。
     */
    public void start() {
        log.info("This thread is {}.", threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}


