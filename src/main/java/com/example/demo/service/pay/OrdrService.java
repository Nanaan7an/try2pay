package com.example.demo.service.pay;

import com.example.demo.pojo.Order;

public interface OrdrService {
    /**
     * 创建订单
     *
     * @param order 请求的订单信息
     * @return 订单信息
     */
    void createOrdr(Order order);
}
