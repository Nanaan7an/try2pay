package com.example.demo.dp.strategy;

import com.example.demo.dp.strategy.behavior.MoveBehavior;
import com.example.demo.dp.strategy.behavior.WeaponBehavior;
import com.example.demo.dp.strategy.behavior.impl.MoveStepImpl;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 */
@Slf4j
@Service
public class Character {

    /**
     * 针对接口或抽象类编程，而不是针对实现类编程
     */
    private MoveBehavior moveBehavior;

    private WeaponBehavior weaponBehavior;

    /**
     * 重写构造器，提供一个默认方法
     */
    public Character() {
        this.moveBehavior = new MoveStepImpl();
    }

    /**
     * 这是一个不会发生变化的方法
     * 每个子类都算是一种职业
     *
     * @return 职业名称
     */
    public String career() {
        return null;
    }


    public void updMove(MoveBehavior m) {
        this.moveBehavior = m;
        this.moveBehavior.toMove();
    }


    public void updWeapon(WeaponBehavior w) {
        this.weaponBehavior.toHit();
    }
}
