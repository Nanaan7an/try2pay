package com.example.demo.frame.stateMechine;

import com.example.demo.frame.stateMechine.factory.ExeFactoryChange;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ExeFactoryChangeTest {
    @Autowired
    ExeFactoryChange exeChange;

    @Test
    void exeChangeCreateSm() throws Exception {
        log.info("创建了一个对象");
        Pay pay1 = new Pay();
        pay1.setPaySts(PayStateEnum.INITIAL.getShortName());
        log.info("初始化状态【{}】", pay1.getPaySts());

        log.info("创建了第二个对象");
        Pay pay2 = new Pay();
        pay2.setPaySts(PayStateEnum.INITIAL.getShortName());
        log.info("2的初始状态【{}】", pay2.getPaySts());


        exeChange.exeChangeCreateSm(pay1, PayEventEnum.SUBMIT);
        log.info("【{}】", pay1.getPaySts());
        exeChange.exeChangeCreateSm(pay1, PayEventEnum.PAY);
        log.info("【{}】", pay1.getPaySts());

        exeChange.exeChangeCreateSm(pay2, PayEventEnum.CLOSE);
        log.info("【{}】", pay2.getPaySts());

        exeChange.exeChangeCreateSm(pay1, PayEventEnum.CLOSE);
        log.info("【{}】", pay1.getPaySts());

        exeChange.exeChangeCreateSm(pay2, PayEventEnum.SUBMIT);
        log.info("【{}】", pay2.getPaySts());
        exeChange.exeChangeCreateSm(pay2, PayEventEnum.PAY);
        log.info("【{}】", pay2.getPaySts());
        exeChange.exeChangeCreateSm(pay2, PayEventEnum.REFUND);
        log.info("【{}】", pay2.getPaySts());
    }

    @Test
    void exeChangeFromDifferentState() throws Exception {
        log.info("创建了一个对象");
        Pay pay1 = new Pay();
        pay1.setPaySts(PayStateEnum.PROCESS.getShortName());
        log.info("业务对象初始化状态【{}】", pay1.getPaySts());

        exeChange.exeChangeFromDifferentState(pay1, PayEventEnum.PAY);
        log.info("【{}】", pay1.getPaySts());

        pay1.setPaySts(PayStateEnum.INITIAL.getShortName());
        log.info("业务对象初始化状态【{}】", pay1.getPaySts());

        exeChange.exeChangeFromDifferentState(pay1, PayEventEnum.CLOSE);
        log.info("【{}】", pay1.getPaySts());
    }


}