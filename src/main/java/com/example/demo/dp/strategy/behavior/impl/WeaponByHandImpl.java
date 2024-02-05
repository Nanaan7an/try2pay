package com.example.demo.dp.strategy.behavior.impl;

import com.example.demo.dp.strategy.behavior.WeaponBehavior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeaponByHandImpl implements WeaponBehavior {
    @Override
    public void toHit() {
      log.info("手搓技能");
    }
}
