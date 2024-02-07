package com.example.demo.service.bill.billservice.downfile;

import com.example.demo.pojo.BatchInfo;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 对账单下载
 */
@Slf4j
@Service
public class DownBillFileService {
    public Boolean downloadFile(BatchInfo batchInfo) {
        log.info("商户[{}]对账单下载", batchInfo.getMerId());
        return true;
    }
}
