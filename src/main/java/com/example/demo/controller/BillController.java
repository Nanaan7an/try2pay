package com.example.demo.controller;


import com.example.demo.service.BatchService;
import com.example.demo.service.bill.BillStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    BatchService batchService;

    @PostMapping("/bill")
    public void bill() {
        batchService.bill();
    }
}
