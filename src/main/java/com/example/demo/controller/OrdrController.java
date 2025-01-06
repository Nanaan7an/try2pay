package com.example.demo.controller;

import com.example.demo.common.log.LogAnnotation;
import com.example.demo.pojo.Order;
import com.example.demo.service.pay.OrdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Nanaan
 * @Date 2024/5/1 19:47
 * @Description TODO
 */
@RestController
public class OrdrController {
    @Autowired
    OrdrService ordrService;

    @PostMapping("/createordr")
    public void createOrdr(Order order) {
        ordrService.createOrdr(order);
    }
}
