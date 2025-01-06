package com.example.demo.frame.stateMechine.branch.action;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 * @Author Nanaan
 * @Date 2024/5/5 18:16
 * @Description TODO
 */

@Slf4j
public class SubmitAction implements Action<PayStateEnum, PayEventEnum> {
    @Override
    public void execute(StateContext<PayStateEnum, PayEventEnum> stateContext) {
        log.info("此次执行的Action是【{}】", PayEventEnum.SUBMIT);
        Pay payInfo = (Pay) stateContext.getMessage().getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.PROCESS.getShortName());
    }
}
