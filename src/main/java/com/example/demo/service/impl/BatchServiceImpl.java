package com.example.demo.service.impl;

import com.example.demo.service.BatchService;
import com.example.demo.service.bill.BillExeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    List<BillExeService> billExeServiceList;

    @Override
    public void bill() {
        for (BillExeService bItem : billExeServiceList) {
            log.info("当前步骤执行【{}】",bItem.getClass());
            bItem.execute();
        }
    }



}
