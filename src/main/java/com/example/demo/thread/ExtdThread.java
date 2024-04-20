package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.example.demo.common.util.DateUtil.getDateTime2;
import static com.example.demo.thread.Mission.mission;

/**
 * @Author Nanaan
 * @Date 2024/4/18 13:59
 * @Description 继承Thread，重写run方法
 */

@Slf4j
@Component
public class ExtdThread extends Thread {
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
     * 尝试使用多线程
     */
    public void useExtdThread() {
        //创建线程对象
        ExtdThread extdThread1 = new ExtdThread();
        ExtdThread extdThread2 = new ExtdThread();
        ExtdThread extdThread3 = new ExtdThread();
        //启动线程，但并不会立即执行，start()需要时间
        extdThread1.start();
        extdThread2.start();
        extdThread3.start();

        log.info("start()启动需要一点时间，所以[useExtdThread]线程剩余的语句和其他线程会交替出现");
        for (int i = 1; i <= 5; i++) {
            log.info("[useExtdThread]第{}次【{}】", i, getDateTime2());
        }
    }
}