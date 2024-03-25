package com.example.demo.service.bill.impl;

import com.example.demo.pojo.BatchInfo;
import com.example.demo.service.bill.billservice.BillService;
import com.example.demo.service.bill.BillExeService;
import com.example.demo.service.bill.billservice.createbill.CreateBillFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(4)
@Service
public class BillCreateImpl extends BillService implements BillExeService {

    @Autowired
    CreateBillFileService createBillFileService;

    @Override
    public void execute() {
        log.info("step4：START！！生成账单");
        for (String merItem : getMers()) {
            BatchInfo batchInfo = getBatch(merItem);
            if (isContinue(batchInfo, BatchStep.CREATE.getStep())) {
                createBillFileService.createloadFile(batchInfo);
            }
        }
        log.info("step4：END！！生成账单");
    }
}
