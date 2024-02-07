package com.example.demo.service.bill.billservice.parsefile;

import com.example.demo.pojo.BatchInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ParseBillFileService {
    public Boolean parseloadFile(BatchInfo batchInfo) {
        log.info("商户[{}]", batchInfo.getMerId());
        return true;
    }
}
