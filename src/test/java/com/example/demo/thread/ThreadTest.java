package com.example.demo.thread;

import com.example.demo.frame.thread.ExtdThread;
import com.example.demo.frame.thread.ImplCallable;
import com.example.demo.frame.thread.ImplRunnable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ThreadTest {
    @Autowired
    ImplRunnable implRunnable;

    @Autowired
    ExtdThread extdThread;

    @Autowired
    ImplCallable implCallable;

    @Test
    void useImplRunnable() {
        log.info("[useImplRunnable]多线程启动！");
        implRunnable.useImplRunnable();
    }
    
    @Test
    void useExtdThread() {
        log.info("[useExtdThread]多线程启动！");
        extdThread.useExtdThread();
    }

    @Test
    void useImplCallable() {
        log.info("[useImplCallable]多线程启动！");
        implCallable.useImplCallable();
    }
}