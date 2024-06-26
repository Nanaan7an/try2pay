package com.example.demo.frame.rpc.server.service.impl;

import com.example.demo.frame.rpc.server.service.HelloService;

/**
 * @Author Nanaan
 * @Date 2024/6/12 16:34
 * @Description TODO
 */

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello" + name);
    }
}
