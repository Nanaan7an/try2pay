package com.example.demo.frame.stateMechine.factory;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * @Author Nanaan
 * @Date 2024/5/2 11:27
 * @Description TODO
 */


@Slf4j
@Component
public class PayFactoryStateMachineBuilder {

    private final static String MACHINEID = "payFactory";

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

        log.info("构建状态机");

        builder.configureConfiguration()
                .withConfiguration()
                .machineId(MACHINEID)
                .beanFactory(beanFactory);


        //初始化
        builder.configureStates()
                .withStates()
                .initial(PayStateEnum.INITIAL)
                .choice(PayStateEnum.PROCESS)
                .states(EnumSet.allOf(PayStateEnum.class));


        //定义状态转换规则
        builder.configureTransitions()

                .withExternal()
                .source(PayStateEnum.INITIAL).target(PayStateEnum.PROCESS).event(PayEventEnum.SUBMIT)
                .and()

                .withExternal()
                .source(PayStateEnum.INITIAL).target(PayStateEnum.CLOSED).event(PayEventEnum.CLOSE)
                .and()

                .withExternal().source(PayStateEnum.PROCESS).event(PayEventEnum.PAY)
                .and()

                .withExternal()
                .source(PayStateEnum.PROCESS).target(PayStateEnum.SUCCESS).event(PayEventEnum.PAY)
                .and()

//                .withExternal()
//                .source(PayStateEnum.PROCESS).target(PayStateEnum.FAILURE).event(PayEventEnum.PAY)
//                .and()


                .withExternal()
                .source(PayStateEnum.SUCCESS).target(PayStateEnum.REFUNDED).event(PayEventEnum.REFUND)
        ;

        return builder.build();
    }

}
