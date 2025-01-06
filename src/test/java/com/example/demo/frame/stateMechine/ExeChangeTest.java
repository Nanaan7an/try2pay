package com.example.demo.frame.stateMechine;

import com.example.demo.frame.stateMechine.single.ExeChange;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ExeChangeTest {

    @Autowired
    ExeChange exeChange;

    /**
     * 全局公用一个状态机
     */
    @Test
    void exeChange() {
        log.info("创建了一个对象并赋初始值");
        Pay pay1 = new Pay();
        pay1.setPaySts(PayStateEnum.INITIAL.getShortName());
        log.info("【{}】初始状态", pay1.getPaySts());

        log.info("创建了另一个对象并赋初始值");
        Pay pay2 = new Pay();
        pay2.setPaySts(PayStateEnum.INITIAL.getShortName());
        log.info("【{}】初始状态", pay2.getPaySts());

        exeChange.exeChangeRepeatStart(pay1, PayEventEnum.SUBMIT);
        log.info("1【{}】", pay1.getPaySts());


        exeChange.exeChangeRepeatStart(pay1, PayEventEnum.PAY);
        log.info("【{}】", pay1.getPaySts());

        exeChange.exeChangeRepeatStart(pay1, PayEventEnum.REFUND);
        log.info("【{}】", pay1.getPaySts());

        exeChange.exeChangeRepeatStart(pay1, PayEventEnum.PAY);
        log.info("【{}】", pay1.getPaySts());


        exeChange.exeChangeRepeatStart(pay2, PayEventEnum.PAY);
        log.info("2【{}】", pay2.getPaySts());



        exeChange.exeChangeRepeatStart(pay2, PayEventEnum.SUBMIT);
        log.info("【{}】", pay2.getPaySts());

        exeChange.exeChangeRepeatStart(pay2, PayEventEnum.REFUND);
        log.info("【{}】", pay2.getPaySts());
    }
}