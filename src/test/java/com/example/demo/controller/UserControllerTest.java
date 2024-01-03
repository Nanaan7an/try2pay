package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {
    @Autowired
    UserController userController;

    @Test
    void addUser() {
        User user=new User();
        user.setName("张三");
        user.setAge(3);
        user.setUserId("1");
        user.setEmail("email");
        userController.addUser(user);
    }
}