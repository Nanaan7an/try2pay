package com.example.demo.service.bill.impl;

import com.example.demo.service.bill.BillStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(3)
@Service
public class BillCheckImpl implements BillStepService {
    @Override
    public void execute() {
        log.info("step3：START！！执行对账");
        log.info("step3：END！！执行对账");
    }
}
