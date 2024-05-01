package com.example.demo.controller;

import com.example.demo.pojo.Pay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PayControllerTest {

    @Autowired
    PayController payController;

    @Test
    void submit() {
        Pay pay = new Pay();
        payController.pay(pay);
    }

    @Test
    void close() {
    }

    @Test
    void pay() {
    }

    @Test
    void refund() {
    }

    @Test
    void query() {
    }
}