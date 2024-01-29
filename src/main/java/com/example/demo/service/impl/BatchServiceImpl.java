package com.example.demo.service.impl;

import com.example.demo.enums.BatchStatus;
import com.example.demo.mapper.MerMapper;
import com.example.demo.pojo.BatchInfo;
import com.example.demo.service.BatchService;
import com.example.demo.service.bill.BillStepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    List<BillStepService> billStepServiceList;

    @Override
    public void bill() {
        for (BillStepService b : billStepServiceList) {
            b.execute();
        }
    }



}
