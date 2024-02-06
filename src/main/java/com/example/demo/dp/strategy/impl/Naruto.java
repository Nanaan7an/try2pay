package com.example.demo.dp.strategy.impl;

import com.example.demo.dp.strategy.Character;
import com.example.demo.dp.strategy.behavior.impl.MoveNotImpl;
import com.example.demo.dp.strategy.behavior.impl.WeaponByHandImpl;
import com.example.demo.dp.strategy.behavior.impl.WeaponBySwordImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Naruto extends Character {
    private final String CATEER = "NINNJA";

    /**
     * 重写构造方法，赋予类的实例对象拥有以下这两个行为，即站在原地和手搓技能
     */
    public Naruto() {
        moveBehavior = new MoveNotImpl();
        weaponBehavior = new WeaponByHandImpl();
    }

    @Override
    public String career() {
        log.info("职业是{}", CATEER);
        return CATEER;
    }
}
