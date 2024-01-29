package com.example.demo.service.bill;

/**
 * 对账
 */
public interface BillStepService {
    /**
     * -1.查询所有商户号
     * -2.遍历商户号，查询批次信息
     * --1.判断当前步骤与批次信息的执行步骤是否对应
     * ---1.对应则执行业务处理
     * ----1.将批次状态置为下一步的状态
     * ---2.否则返回
     */
    void execute();
}
