package com.example.demo.pojo;

import lombok.Data;

/**
 * 批次信息
 */
@Data
public class BatchInfo {
    /*
    批次日期
     */
    private String batchDate;
    /*
    批次状态
     */
    private String batchSts;
    /*
    批次步骤
     */
    private String batchStep;

    /*
    商户号
     */
    private String merId;

}
