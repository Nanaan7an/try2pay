package com.example.demo.controller;

import com.example.demo.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdrControllerTest {

    @Autowired
    OrdrController ordrController;

    @Test
    void createOrdr() {
        Order order = new Order();

        order.setMerId("Mer1");
        order.setUserId("2");

        ordrController.createOrdr(order);
    }
}