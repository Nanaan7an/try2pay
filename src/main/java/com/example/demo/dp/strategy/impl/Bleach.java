package com.example.demo.dp.strategy.impl;

import com.example.demo.dp.strategy.Character;
import com.example.demo.dp.strategy.behavior.impl.MoveNotImpl;
import com.example.demo.dp.strategy.behavior.impl.WeaponBySwordImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Bleach extends Character {
    private final String CATEER = "SHINIGAMO";

    /**
     * 重写构造方法，该类的实例对象默认有的行为，即站在原地和使用剑
     */
    public Bleach() {
        moveBehavior = new MoveNotImpl();
        weaponBehavior = new WeaponBySwordImpl();
    }

    @Override
    public String career() {
        log.info("职业是{}", CATEER);
        return CATEER;
    }
}
