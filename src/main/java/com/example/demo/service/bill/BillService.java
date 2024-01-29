package com.example.demo.service.bill;

import com.example.demo.enums.BatchStatus;
import com.example.demo.mapper.BatchMapper;
import com.example.demo.mapper.MerMapper;
import com.example.demo.pojo.BatchInfo;
import com.example.demo.pojo.MerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (step.equals(batchInfo.getBatchStep()) && !BatchStatus.FAIL.equals(batchInfo.getBatchSts())) {
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
        BatchInfo batchInfo=new BatchInfo();
        batchInfo.setMerId(merId);
        batchInfo.setBatchDate("昨天把");
        return batchMapper.queryBatchByMer(merId);
    }

}
