package com.example.demo.frame.stateMechine.branch;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.frame.stateMechine.branch.action.*;
import com.example.demo.frame.stateMechine.branch.guard.PayGuard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * @Author Nanaan
 * @Date 2024/5/5 17:36
 * @Description 带有分支的状态转换
 */

@Slf4j
@Component
public class PayBranchStateMachineBuilder {

    private final static String MACHINEID = "payBranch";

    /**
     * 与单例模式下的Config类似的，但是都在这一个方法中配置好了。
     * 每次调用builde方法都会创建一个新的状态机
     *
     * @param beanFactory
     * @return
     * @throws Exception
     */
    public StateMachine<PayStateEnum, PayEventEnum> build(BeanFactory beanFactory) throws Exception {
        StateMachineBuilder.Builder<PayStateEnum, PayEventEnum> builder = StateMachineBuilder.builder();

        log.info("构建带有分支的状态机");

        builder.configureConfiguration()
                .withConfiguration()
                .machineId(MACHINEID)
                .beanFactory(beanFactory);


        //初始化
        builder.configureStates()
                .withStates()
                .initial(PayStateEnum.INITIAL)
                .choice(PayStateEnum.PROCESS_CHOICE)
                .states(EnumSet.allOf(PayStateEnum.class));


        //定义状态转换规则
        builder.configureTransitions()

                .withExternal()
                .source(PayStateEnum.INITIAL).target(PayStateEnum.PROCESS).event(PayEventEnum.SUBMIT)
                .action(new SubmitAction())
                .and()

                .withExternal()
                .source(PayStateEnum.INITIAL).target(PayStateEnum.CLOSED).event(PayEventEnum.CLOSE)
                .action(new CloseAction())
                .and()
                /**
                 * 这部分是有分支的情况的写法。需要注意的是，EventConfig中的方法不会被执行，此时想要做想应的业务处理，有以下两种方式。
                 *1.Guard()会被执行，业务处理写在这个类的方法里。
                 * 2.上个方法太聚合，用action实现解耦。
                 * 一般不需要为选择状态指定事件，选择状态是根据当前状态和Guard的结果来判断的，不基于接收到的事件，
                 */
                .withExternal()
                .source(PayStateEnum.PROCESS).target(PayStateEnum.PROCESS_CHOICE).event(PayEventEnum.PAY)
                .and()
                .withChoice()
                .source(PayStateEnum.PROCESS_CHOICE)
                .first(PayStateEnum.SUCCESS, new PayGuard(), new Pay2SAction())
                .last(PayStateEnum.FAILURE, new Pay2FAction())
                .and()

                .withExternal()
                .source(PayStateEnum.SUCCESS).target(PayStateEnum.REFUNDED).event(PayEventEnum.REFUND)
                .action(new RefundAction())
        ;

        return builder.build();
    }

}
