package com.example.demo.controller;

import com.example.demo.common.log.LogAnnotation;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.Pay;
import com.example.demo.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Nanaan
 * @Date 2024/5/1 19:47
 * @Description TODO
 */

@RestController
public class PayController {
    @Autowired
    PayService payService;

    @LogAnnotation(value = "submit")
    @PostMapping("/submit")
    public void submit(Order order) {
        payService.submit(order);
    }

    @LogAnnotation(value = "close")
    @PostMapping("/close")
    public Pay close(Pay pay) {
        return payService.close(pay);
    }

    @LogAnnotation(value = "pay")
    @PostMapping("/pay")
    public Pay pay(Pay pay) {
        return payService.pay(pay);
    }

    @LogAnnotation(value = "refund")
    @PostMapping("/refund")
    public Pay refund(Pay pay) {
        return payService.refund(pay);
    }

    @LogAnnotation(value = "query")
    @PostMapping("/query")
    public Pay query(Pay pay) {
        return payService.query(pay);
    }
}
