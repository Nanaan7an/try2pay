package com.example.demo.service.pay.impl;

import com.example.demo.mapper.PayMapper;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.Pay;
import com.example.demo.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Nanaan
 * @Date 2024/5/1 18:52
 * @Description 支付Service
 */

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    PayMapper payMapper;

    @Override
    public int submit(Order order) {
        return 0;
    }

    @Override
    public Pay close(Pay pay) {
        return null;
    }

    @Override
    public Pay pay(Pay pay) {
        return null;
    }

    @Override
    public Pay refund(Pay pay) {
        return null;
    }

    @Override
    public Pay query(Pay pay) {
        return null;
    }
}
