package com.example.demo.dp.strategy.behavior.impl;

import com.example.demo.dp.strategy.behavior.MoveBehavior;
import lombok.extern.slf4j.Slf4j;

/**
 * 移动实现类
 */
@Slf4j
public class MoveStepImpl implements MoveBehavior {
    @Override
    public void toMove() {
      log.info("移动了一步");
    }
}
