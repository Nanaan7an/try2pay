package com.example.demo.service.bill.billservice;

import com.example.demo.enums.BatchStatusEnum;
import com.example.demo.mapper.BatchMapper;
import com.example.demo.mapper.MerMapper;
import com.example.demo.pojo.BatchInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 对账中用到的一些辅助方法
 */
@Slf4j
@Service
public class BillService {

    @Autowired
    MerMapper merMapper;

    @Autowired
    BatchMapper batchMapper;

    /**
     * 是否继续执行下一步
     *
     * @param batchInfo 批次信息
     * @param step      此时正确的步骤
     * @return true-继续执行
     */
    public Boolean isContinue(BatchInfo batchInfo, String step) {
        if (step.equals(batchInfo.getBatchStep()) && !BatchStatusEnum.FAIL.getSts().equals(batchInfo.getBatchSts())) {
            return true;
        }
        return false;
    }

    /**
     * 查询所有商户号
     *
     * @return 商户号列表
     */
    public List<String> getMers() {
        return merMapper.queryAllMer();
    }

    /**
     * 根据商户号查询批次信息，若存在则返回查询结果，若不存在则新增
     *
     * @param merId
     * @return
     */
    public BatchInfo getBatch(String merId) {
        BatchInfo batchInfo = new BatchInfo();
        batchInfo.setMerId(merId);
        //对账日期，当前日期的前一个自然日
        batchInfo.setBatchDate(LocalDate.now().plusDays(-1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        BatchInfo queryBatch = queryBatch(batchInfo);
        if (queryBatch == null) {
            batchInfo.setBatchStep(BatchStatusEnum.DOWN.getSts());
            addBatch(batchInfo);
            return batchInfo;
        }
        return queryBatch;
    }

    /**
     * 查询批次信息
     *
     * @param batchInfo
     * @return
     */
    public BatchInfo queryBatch(BatchInfo batchInfo) {
        return batchMapper.queryBatch(batchInfo);
    }

    /**
     * 新增批次信息
     *
     * @param batchInfo
     */
    public void addBatch(BatchInfo batchInfo) {
        batchMapper.addBatch(batchInfo);
    }

}
