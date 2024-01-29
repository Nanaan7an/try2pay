package com.example.demo.service.bill.impl;

import com.example.demo.enums.BatchStep;
import com.example.demo.pojo.BatchInfo;
import com.example.demo.service.bill.BillService;
import com.example.demo.service.bill.BillStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(2)
@Service
public class BillParseImpl extends BillService implements BillStepService {
    @Override
    public void execute() {
        log.info("step2：START！！解析账单");
        for (String merItem : getMers()) {
            BatchInfo batchInfo = getBatch(merItem);
            if (isContinue(batchInfo, BatchStep.PARSE.getStep())) {

            }
        }
        log.info("step2：END！！解析账单");
    }
}
