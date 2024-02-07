package com.example.demo.controller;


import com.example.demo.common.log.LogAnnotation;
import com.example.demo.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
    @Autowired
    BatchService batchService;

    @LogAnnotation(title = "对账")
    @PostMapping("/bill")
    public void bill() {
        batchService.bill();
    }
}
