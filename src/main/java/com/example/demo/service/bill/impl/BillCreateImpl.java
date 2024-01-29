package com.example.demo.service.bill.impl;

import com.example.demo.enums.BatchStep;
import com.example.demo.pojo.BatchInfo;
import com.example.demo.service.bill.BillService;
import com.example.demo.service.bill.BillStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(4)
@Service
public class BillCreateImpl extends BillService implements BillStepService {
    @Override
    public void execute() {
        log.info("step4：START！！生成账单");
        for (String merItem : getMers()) {
            BatchInfo batchInfo = getBatch(merItem);
            if (isContinue(batchInfo, BatchStep.CREATE.getStep())) {

            }
        }
        log.info("step4：END！！生成账单");
    }
}
