package com.example.demo.frame.stateMechine.single;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @Author Nanaan
 * @Date 2024/4/30 19:18
 * @Description 状态机事件实现类
 */

@Slf4j
@Configuration
@WithStateMachine(name = "pay")
public class PayEventConfig {

    @OnTransition(source = "INITIAL", target = "PROCESS")
    public void submit(Message<PayEventEnum> msg) {
        log.info("此次执行的事件是【{}】", PayEventEnum.SUBMIT);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.PROCESS.getShortName());
    }

    @OnTransition(source = "INITIAL", target = "CLOSED")
    public void close(Message<PayEventEnum> msg) {
        log.info("此次执行的事件是【{}】", PayEventEnum.CLOSE);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.CLOSED.getShortName());
    }

    @OnTransition(source = "PROCESS", target = "SUCCESS")
    public void paySuccess(Message<PayEventEnum> msg) {
        log.info("此次执行的事件是【{}】", PayEventEnum.PAY);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.SUCCESS.getShortName());
    }

//    @OnTransition(source = "PROCESS", target = "FAILURE")
//    public void payFail(Message<PayEventEnum> msg) {
//        log.info("此次执行的事件是【{}】", PayEventEnum.PAY);
//        Pay payInfo = (Pay) msg.getHeaders().get("info");
//        payInfo.setPaySts(PayStateEnum.FAILURE.getShortName());
//    }

    @OnTransition(source = "SUCCESS", target = "REFUNDED")
    public void refund(Message<PayEventEnum> msg) {
        log.info("此次执行的事件是【{}】", PayEventEnum.REFUND);
        Pay payInfo = (Pay) msg.getHeaders().get("info");
        payInfo.setPaySts(PayStateEnum.REFUNDED.getShortName());
    }
}
