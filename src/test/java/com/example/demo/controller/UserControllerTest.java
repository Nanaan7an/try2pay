package com.example.demo.controller;

import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class UserControllerTest {
    @Autowired
    UserController userController;

    @Test
    void addUser() {
        User user = new User();
        user.setUserName("张三");
        user.setAge(3);
        user.setUserId(1);
        user.setEmail("email");
        userController.addUser(user);
    }

    @Test
    void queryAllUser() {
        log.info("查询所有User={}", userController.queryAllUser());
    }

    @Test
    void queryUserById() {
        int id = 1;
        System.out.println(userController.queryUserById(id));
    }

    @Test
    void changeUser() {
        User user = new User();
        user.setAge(4);
        user.setUserId(1);
        System.out.println(userController.changeUser(user));
    }

    @Test
    void delUser() {
        User user = new User();
        user.setUserId(2);
        System.out.println(userController.delUser(user));
    }

}