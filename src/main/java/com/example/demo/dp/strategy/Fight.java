package com.example.demo.dp.strategy;

import com.example.demo.dp.strategy.behavior.impl.MoveRunImpl;
import com.example.demo.dp.strategy.behavior.impl.MoveStepImpl;
import com.example.demo.dp.strategy.impl.Bleach;
import com.example.demo.dp.strategy.impl.Naruto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 测试类
 */
@Service
@Slf4j
public class Fight {
    public void test() {
        Character ichigo = new Bleach();
        ichigo.setName("ichigo");
        log.info("现在的角色是{}", ichigo.getName());
        ichigo.career();
        ichigo.performMove();
        ichigo.setMoveBehavior(new MoveStepImpl());
        ichigo.performMove();
        ichigo.performWeapon();

        Character narutchan=new Naruto();
        narutchan.setName("narutchan");
        log.info("现在的角色是{}", narutchan.getName());
        narutchan.career();
        ichigo.performMove();
        narutchan.setMoveBehavior(new MoveRunImpl());
        narutchan.performMove();
        narutchan.performWeapon();
    }
}
