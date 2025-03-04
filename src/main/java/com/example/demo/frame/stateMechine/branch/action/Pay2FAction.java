package com.example.demo.frame.stateMechine.branch.action;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 * @Author Nanaan
 * @Date 2024/5/5 13:22
 * @Description P转换为F时的业务处理方法
 */

@Slf4j
public class Pay2FAction implements Action<PayStateEnum, PayEventEnum> {
    @Override
    public void execute(StateContext<PayStateEnum, PayEventEnum> stateContext) {
        log.info("此次执行的Action是【{}】", PayEventEnum.PAY);
        Pay payInfo = stateContext.getMessage().getHeaders().get("info",Pay.class);
        payInfo.setPaySts(PayStateEnum.FAILURE.getShortName());
    }
}
