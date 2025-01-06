package com.example.demo.frame.stateMechine.branch.guard;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.guard.Guard;

/**
 * @Author Nanaan
 * @Date 2024/5/5 12:10
 * @Description 支付时，业务对象状态根据条件判断的结果转换为S或F，此处是做条件判断。
 */

@Slf4j
public class PayGuard implements Guard<PayStateEnum, PayEventEnum> {
    /**
     * 状态转换的条件判断。
     * 本例中的状态判断是通过在调用状态机时，传入可以用于状态判断的参数。
     *
     * @param stateContext 状态机上下文
     * @return true-转换为状态机定义中.first()的状态；false-转换为状态机定义中.last()的状态；
     */
    @Override
    public boolean evaluate(StateContext<PayStateEnum, PayEventEnum> stateContext) {
        log.info("状态判断遇到了分支！此处是在判断P转换为S/F");
        String state = stateContext.getMessage().getHeaders().get("state", String.class);
        boolean result = state.equals(PayStateEnum.SUCCESS.getShortName());
        log.info("判断转换为S？结果是【{}】", result);
        return result;
    }
}

