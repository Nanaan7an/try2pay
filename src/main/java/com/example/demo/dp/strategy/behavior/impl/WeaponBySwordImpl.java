package com.example.demo.dp.strategy.behavior.impl;

import com.example.demo.dp.strategy.behavior.WeaponBehavior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeaponBySwordImpl implements WeaponBehavior {
    @Override
    public void toHit() {
        log.info("用剑攻击");
    }
}
