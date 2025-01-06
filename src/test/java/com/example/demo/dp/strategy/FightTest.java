package com.example.demo.dp.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FightTest {

    @Autowired
    Fight fight;

    @Test
    void test() {
        fight.test();
    }
}