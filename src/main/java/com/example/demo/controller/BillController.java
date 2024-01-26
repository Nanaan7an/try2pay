package com.example.demo.controller;


import com.example.demo.service.bill.BillStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    List<BillStepService> billList;

    @PostMapping("/bill")
    public void bill() {
        for (BillStepService b : billList) {
            b.execute();
        }
    }
}
