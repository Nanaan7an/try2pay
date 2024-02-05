package com.example.demo.dp.strategy.behavior.impl;

import com.example.demo.dp.strategy.behavior.MoveBehavior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MoveRunImpl implements MoveBehavior {
    @Override
    public void toMove() {
        log.info("跑起来了");
    }
}
