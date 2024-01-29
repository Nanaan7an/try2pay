package com.example.demo.mapper;

import com.example.demo.pojo.BatchInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BatchMapper {
    /**
     * 新增批次信息
     *
     * @param batchInfo 批次信息
     * @return 操作影响的行数
     */
    int addBatch(BatchInfo batchInfo);

    /**
     * 删除批次信息
     *
     * @param batchInfo 批次信息
     * @return 操作影响的行数
     */
    int delBatch(BatchInfo batchInfo);

    /**
     * 修改批次信息
     *
     * @param batchInfo 批次信息
     * @return 操作影响的行数
     */
    int changeBatch(BatchInfo batchInfo);

    /**
     * 查询批次信息
     *
     * @param batchInfo 批次信息
     * @return 查询结果
     */
    List<BatchInfo> queryBatchList(BatchInfo batchInfo);

    /**
     * 查询一条批次信息
     * @param batchInfo 批次信息
     * @return 查询结果
     */
    BatchInfo queryBatch(BatchInfo batchInfo);

    /**
     * 根据商户号查询批次信息
     * @param merId 商户号
     * @return 查询结果
     */
    BatchInfo queryBatchByMer(String merId);
}
