package com.example.demo.service.bill.impl;

import com.example.demo.service.bill.BillStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(2)
@Service
public class BillParseImpl implements BillStepService {
    @Override
    public void execute() {
        log.info("step2：START！！解析账单");
        log.info("step2：END！！解析账单");
    }
}
