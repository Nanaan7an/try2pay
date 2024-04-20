package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

import static com.example.demo.common.util.DateUtil.getDateTime2;
import static com.example.demo.thread.Mission.mission;

/**
 * @Author Nanaan
 * @Date 2024/4/20 15:37
 * @Description 实现Callable，重写call方法，可以返回结果，可能抛出异常
 */
@Slf4j
@Component
public class ImplCallable implements Callable {

    @Override
    public Boolean call() throws Exception {
        log.info("【{}】->BeginTms【{}】", Thread.currentThread().getName(), getDateTime2());
        mission();
        log.info("【{}】->EndTms【{}】", Thread.currentThread().getName(), getDateTime2());
        return true;
    }

    public void useImplCallable() {
        ImplCallable c1 = new ImplCallable();
        ImplCallable c2 = new ImplCallable();
        ImplCallable c3 = new ImplCallable();
        //创建线程池执行服务，传入线程数；newFixedThreadPool(int nThreads)创建一个可重用固定线程数的线程池，
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> future1 = executorService.submit(c1);
        Future<Boolean> future2 = executorService.submit(c2);
        Future<Boolean> future3 = executorService.submit(c3);

        try {
            Boolean b1 = future1.get();
            Boolean b2 = future2.get();
            Boolean b3 = future3.get();
        } catch (Exception e) {
            log.error("线程出现异常了，异常信息：", e);
        } finally {
            //关闭服务，保证线程池安全
            executorService.shutdownNow();
        }
    }
}
