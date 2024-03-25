package com.example.demo.service.bill.impl;

import com.example.demo.pojo.BatchInfo;
import com.example.demo.service.bill.billservice.BillService;
import com.example.demo.service.bill.BillExeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(3)
@Service
public class BillCheckImpl extends BillService implements BillExeService {
    @Override
    public void execute() {
        log.info("step3：START！！执行对账");
        for (String merItem : getMers()) {
            BatchInfo batchInfo = getBatch(merItem);
            if (isContinue(batchInfo, BatchStep.CHECK.getStep())){

            }
        }
        log.info("step3：END！！执行对账");
    }
}
