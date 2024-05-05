package com.example.demo.frame.stateMechine;

import com.example.demo.frame.stateMechine.branch.ExeBranchChange;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ExeBranchChangeTest {

    @Autowired
    ExeBranchChange exeChange;

    @Test
    void exeChangeBranchs() throws Exception {

        log.info("创建了一个对象");
        Pay pay1 = new Pay();

        pay1.setPaySts(PayStateEnum.INITIAL.getShortName());
        log.info("业务对象初始化状态【{}】", pay1.getPaySts());

        exeChange.exeChangeBranchs(pay1, PayEventEnum.SUBMIT, "F");
        log.info("先做一个别的事情的时候【{}】", pay1.getPaySts());

        log.info("==========");

        log.info("创建了另一个对象");
        Pay pay2 = new Pay();

        pay2.setPaySts(PayStateEnum.PROCESS.getShortName());
        log.info("pay2业务对象初始化状态【{}】", pay2.getPaySts());

        exeChange.exeChangeBranchs(pay2, PayEventEnum.PAY, "S");
        log.info("pay2传入分支判断是S的时候【{}】", pay2.getPaySts());
    }
}