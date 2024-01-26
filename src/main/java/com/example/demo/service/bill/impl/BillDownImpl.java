package com.example.demo.service.bill.impl;

import com.example.demo.service.bill.BillStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(1)
@Service
public class BillDownImpl implements BillStepService {
    @Override
    public void execute() {
      log.info("step1：START！！下载账单");
      log.info("step1：END！！下载账单");
    }
}
