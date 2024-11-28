package com.example.demo.frame.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mission4ListTest {

    @Autowired
    Mission4List mission4List;

    @Test
    void exeThread() {
        mission4List.exeThread();
    }
}