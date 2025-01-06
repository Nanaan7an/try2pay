package com.example.demo.frame.thread;

import com.example.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DemoApplication.class})  
class Mission4ListTest {

    @Autowired
    ImplRunnable4List implRunnable4List;

    @Test
    void exeThread() {
        implRunnable4List.exeThread();
    }
}