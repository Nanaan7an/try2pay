package com.example.demo.frame.stateMechine.branch;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.example.demo.frame.stateMechine.PayStateEnum.findName;

/**
 * @Author Nanaan
 * @Date 2024/5/5 17:44
 * @Description TODO
 */

@Slf4j
@Component
public class ExeBranchChange {
    @Autowired
    PayBranchStateMachineBuilder builder;

    @Autowired
    BeanFactory beanFactory;

    @Autowired
    StateMachine<PayStateEnum, PayEventEnum> stateMachine;
    @Resource(name = "payPersister")
    private StateMachinePersister<PayStateEnum, PayEventEnum, Pay> persister;

    /**
     * 第四话
     * 实现多分支。有分支就有判断条件，此处的处理方式把想要判断的条件作为参数传到状态机中去，便于后续的逻辑处理。
     * 当然也可以不传另外的值，此时如果想要实现分支判断，就只能从业务对象本身的值入手。
     * 二者没有什么优劣之分，主要看需求。
     *
     * @param payInfo      将要执行状态变迁的实例
     * @param payEventEnum 事件
     * @param state        分支判断的依据。本例中的分支判断的来源是外部，所以需要单独传值过去。
     */
    public void exeChangeBranchs(Pay payInfo, PayEventEnum payEventEnum, String state) throws Exception {
        log.info("试试分支");
        payInfo.setPaySts(findName(payInfo.getPaySts()));

        Message msg = MessageBuilder.withPayload(payEventEnum)
                .setHeader("info", payInfo)
                .setHeader("state", state)
                .build();
        stateMachine = builder.build(beanFactory);
        stateMachine.start();
        //恢复
        persister.restore(stateMachine, payInfo);
        log.info("状态机执行事件之前的状态是【{}】", stateMachine.getState().getId());
        stateMachine.sendEvent(msg);
        log.info("sendEvent之后的状态机状态值是【{}】", stateMachine.getState().getId());
    }

    /**
     * @param payInfo
     * @param payEventEnum
     * @param state
     */
    public void exeChangeFromDifferentState(Pay payInfo, PayEventEnum payEventEnum, String state) {
    }
}
