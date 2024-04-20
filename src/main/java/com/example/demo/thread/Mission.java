package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

import static com.example.demo.common.util.DateUtil.getDateTime2;

/**
 * @Author Nanaan
 * @Date 2024/4/20 15:13
 * @Description 线程执行的任务，以多个线程同时购买同一类票为例
 */

@Slf4j
public class Mission {
    /**
     * 定义票的总数。
     * 之所以写为全局变量，是为了避免在每个线程运行时都初始化值。
     */
    private static int ticket = 10;

    /**
     * 线程中使用的方法：
     * 抛出异常，给调用链上的调用此方法的方法run()处理异常
     */
    public static void mission() throws InterruptedException {
        while (ticket > 0) {
            //线程休眠，放大问题
//            Thread.sleep(10);
            log.info("【{}】抢到票了，还有【{}】张余票【{}】", Thread.currentThread().getName(), --ticket, getDateTime2());
        }
    }
}
