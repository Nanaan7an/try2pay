package com.example.demo.service.bill.impl;

import com.example.demo.service.bill.BillStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(4)
@Service
public class BillCreateImpl implements BillStepService {
    @Override
    public void execute() {
        log.info("step4：START！！生成账单");
        log.info("step4：END！！生成账单");
    }
}
