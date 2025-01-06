package com.example.demo.frame.stateMechine.factory;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @Author Nanaan
 * @Date 2024/5/2 11:42
 * @Description 业务事件处理类
 */

@Slf4j
@WithStateMachine(id = "payFactory")
public class PayFactoryEventConfig {

    @OnTransition(source = "INITIAL", target = "PROCESS")
    public void submit(Message<PayEventEnum> msg) {
        log.info("PayFactoryEventConfig此次执行的事件是【{}】", PayEventEnum.SUBMIT);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.PROCESS.getShortName());
    }

    @OnTransition(source = "INITIAL", target = "CLOSED")
    public void close(Message<PayEventEnum> msg) {
        log.info("PayFactoryEventConfig此次执行的事件是【{}】", PayEventEnum.CLOSE);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.CLOSED.getShortName());
    }

    @OnTransition(source = "PROCESS", target = "SUCCESS")
    public void paySuccess(Message<PayEventEnum> msg) {
        log.info("PayFactoryEventConfig此次执行的事件是【{}】", PayEventEnum.PAY);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.SUCCESS.getShortName());
    }

    @OnTransition(source = "PROCRESS", target = "FAILURE")
    public void payFail(Message<PayEventEnum> msg) {
        log.info("PayFactoryEventConfig此次执行的事件是【{}】", PayEventEnum.PAY);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.FAILURE.getShortName());
    }

    @OnTransition(source = "SUCCESS", target = "REFUNDED")
    public void refund(Message<PayEventEnum> msg) {
        log.info("PayFactoryEventConfig此次执行的事件是【{}】", PayEventEnum.REFUND);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.REFUNDED.getShortName());
    }
}
