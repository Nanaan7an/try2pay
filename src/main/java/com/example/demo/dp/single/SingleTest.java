package com.example.demo.dp.single;

import lombok.extern.slf4j.Slf4j;

public class SingleTest {
    public void test() {
        /**
         * 测试
         */
        SingleInstanceHungry s1 = SingleInstanceHungry.getInstance();
        SingleInstanceHungry s2 = SingleInstanceHungry.getInstance();
        System.out.println(s1.equals(s2));

    }
}
