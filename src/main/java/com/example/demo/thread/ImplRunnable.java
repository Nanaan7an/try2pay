package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.example.demo.common.util.DateUtil.getDateTime2;
import static com.example.demo.thread.Mission.mission;

/**
 * @Author Nanaan
 * @Date 2024/4/18 13:46
 * @Description 实现Runnable，重写run();
 * 如果只想重写run()方法，而不重写其他Thread方法，那么应使用Runnable接口。
 */

@Slf4j
@Component
public class ImplRunnable implements Runnable {
    /**
     * 重写Runnable接口中的run()；
     * 捕捉异常并处理
     */
    @Override
    public void run() {
        log.info("【{}】->BeginTms【{}】", Thread.currentThread().getName(), getDateTime2());
        try {
            mission();
        } catch (InterruptedException e) {
//            Call to 'printStackTrace()' should probably be replaced with more robust logging ，使用printStackTrace()可能会导致死锁，更改为log4j框架打印日志
//            e.printStackTrace();
            log.error("线程出现异常了，异常信息：", e);
        } finally {
            log.info("【{}】平安无事", Thread.currentThread().getName());
        }
        log.info("【{}】->EndTms【{}】", Thread.currentThread().getName(), getDateTime2());
    }

    /**
     * 尝试使用多线程，多个线程操作同一个对象，可能出现数据紊乱，即ticket并未按照严格降序打印，需要解决并发问题
     */
    public void useImplRunnable() {
        //创建Runnable实现类对象
        ImplRunnable implRunnable = new ImplRunnable();
        //创建Thread对象，以Runnable实现类对象作为参数；此处同时执行同一实例的run方法来模拟多线程
        Thread thread1 = new Thread(implRunnable, "thread1");
        Thread thread2 = new Thread(implRunnable, "thread2");
        Thread thread3 = new Thread(implRunnable, "thread3");
        //启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
