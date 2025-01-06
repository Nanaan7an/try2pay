package com.example.demo.service.pay.impl;

import com.example.demo.mapper.OrdrMapper;
import com.example.demo.pojo.Order;
import com.example.demo.service.pay.OrdrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.common.util.DateUtil.DATETIME3;
import static com.example.demo.common.util.DateUtil.getDateTimeOf;

/**
 * @Author Nanaan
 * @Date 2024/5/1 18:51
 * @Description 订单Service
 */

@Service
@Slf4j
public class OrdrServiceImpl implements OrdrService {

    @Autowired
    OrdrMapper ordrMapper;

    @Override
    public void createOrdr(Order order) {
        log.info("创建订单开始");
        order.setOrderId("ORDR" + getDateTimeOf(DATETIME3));
        int result = ordrMapper.add(order);
        if (result < 0) {
            log.error("插入订单信息失败！Order={}", order);
        }
    }
}
