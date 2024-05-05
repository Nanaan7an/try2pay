package com.example.demo.frame.stateMechine.single;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @Author Nanaan
 * @Date 2024/4/28 14:46
 * @Description 状态机配置类
 */
@Configuration
@EnableStateMachine
public class PayStateMachineConfig extends EnumStateMachineConfigurerAdapter<PayStateEnum, PayEventEnum> {
    /**
     * 定义machineId，实现关联状态机配置类和事件实现类。
     * 必须得有这个方法，不然找不着事件的业务处理类；此时可以根据事件更改状态机的状态，但并不能使得业务数据发生变化。
     *
     * @param config
     * @throws Exception
     */
    @Override
    public void configure(StateMachineConfigurationConfigurer<PayStateEnum, PayEventEnum> config) throws Exception {
        config.withConfiguration().machineId("pay");
    }

    /**
     * 初始化
     *
     * @param state
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<PayStateEnum, PayEventEnum> state) throws Exception {
        state.withStates()
                .initial(PayStateEnum.INITIAL)
                .states(EnumSet.allOf(PayStateEnum.class));
    }

    /**
     * 定义状态转换对应的事件，即状态机的流程
     *
     * @param transition
     * @throws Exception
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<PayStateEnum, PayEventEnum> transition) throws Exception {
        transition

                .withExternal().source(PayStateEnum.INITIAL).target(PayStateEnum.PROCESS).event(PayEventEnum.SUBMIT)
                .and()

                .withExternal().source(PayStateEnum.INITIAL).target(PayStateEnum.CLOSED).event(PayEventEnum.CLOSE)
                .and()

//                .withExternal().source(PayStateEnum.PROCRESS).event(PayEventEnum.PAY)
//                .and()

                .withExternal().source(PayStateEnum.PROCESS).target(PayStateEnum.SUCCESS).event(PayEventEnum.PAY)
                .and()

//                .withExternal().source(PayStateEnum.PROCRESS).target(PayStateEnum.FAILURE).event(PayEventEnum.PAY)
//                .and()

                .withExternal().source(PayStateEnum.SUCCESS).target(PayStateEnum.REFUNDED).event(PayEventEnum.REFUND)
        ;
    }
}
