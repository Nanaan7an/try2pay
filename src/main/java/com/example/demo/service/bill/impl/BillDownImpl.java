package com.example.demo.service.bill.impl;

import com.example.demo.enums.BatchStep;
import com.example.demo.pojo.BatchInfo;
import com.example.demo.service.bill.BillService;
import com.example.demo.service.bill.BillStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(1)
@Service
public class BillDownImpl extends BillService implements BillStepService {

    @Autowired
    BillService billService;

    @Override
    public void execute() {
        log.info("step1：START！！下载账单");
        for (String merItem : getMers()) {
            BatchInfo batchInfo = getBatch(merItem);
            if (isContinue(batchInfo, BatchStep.DOWN.getStep())){

            }
        }
        log.info("step1：END！！下载账单");
    }
}
