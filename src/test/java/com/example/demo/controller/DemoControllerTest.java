package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoControllerTest {

    @Autowired
    DemoController demoController;

    @Test
    void demoTry() {
        demoController.demoTry();
    }
}