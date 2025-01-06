package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillControllerTest {

    @Autowired
    BillController billController;

    @Test
    void bill() {
        billController.bill();
    }
}