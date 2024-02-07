package com.example.demo.service.bill.billservice.createbill;

import com.example.demo.pojo.BatchInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateBillFileService {
    public Boolean createloadFile(BatchInfo batchInfo) {
        log.info("商户[{}]", batchInfo.getMerId());
        return true;
    }
}
