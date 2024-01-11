package com.example.demo.controller;

import com.example.demo.common.constant.GlobalConstant;
import com.example.demo.common.log.LogAnnotation;
import com.example.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
@Controller，使得类里面的每个方法都返回一个视图页面；一般使用时，后端返回应该为一些数据，而不是一个视图。
@ResponseBody，表示返回数据而不是视图，可用在方法/类上（生效的作用域不同）。
@RestController，上述两注解的合并版。
@RequestMapping("/url")，可用在方法/类上。
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {
    @Autowired
    DemoService service;

    @Autowired
    GlobalConstant globalConstant;


    @LogAnnotation(title = "try")
    @RequestMapping(value = "/try", method = RequestMethod.GET)
    public String demoTry() {
        log.info("globalConstant.getAuthorName()={}", globalConstant.getAuthorName());
        return "ok";
    }
}
