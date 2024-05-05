package com.example.demo.frame.stateMechine.single;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 * @Author Nanaan
 * @Date 2024/4/30 19:20
 * @Description 调用状态机，实现业务对象状态变化
 */
@Slf4j
@Component
public class ExeChange {

    @Autowired
    private StateMachine<PayStateEnum, PayEventEnum> stateMachine;

    /**
     * 第一话
     * 状态机每次start之后都会重置状态机的状态为StateMachineConfig方法里设置的初始状态；以下均是指在一次运行中【毕竟生产上的工程也不会经常重启】。
     * 1.本方法中，每次调用都会先start一下，结束本次调用后会stop，所以每一次调用本方法时，状态机的当前状态都是初始状态I。
     * 验证方法：在本方法中调用start、stop方法，在测试类中连续调用多次本方法，事件与事件发生顺序不受约束。
     * 执行结果：①当状态机的当前状态和执行的事件在StateMachineConfig有对应的定义的时候，状态机的状态才会改变为对应定义的目标状态；
     * ②此时状态机会主动调用相关的事件处理方法，业务对象的状态值按照方法中的setter改变。
     * ③在本例中，只有[初始状态是状态机定义的初始状态]的事件才会被正确执行。此时，显然不会理会业务对象的当前状态，对应事件发生了，业务对象的值就会改变，完全不care业务流程【也就是说可能会发生P->C】。
     * 2.若此方法中只start而不stop，表示状态机不会每次都会被初始化到初始状态，而是保留上一次执行的结果，原理和上述一致。
     * 验证方法：若连续调用，且连续调用的事件中存在符合业务流程的事件流；也就是说，在一个符合正常执行逻辑的事件流中，任意插入事件并执行。
     * 执行结果：①状态机的状态和业务对象的状态可以按照业务流程从初始状态，经过中间态变化到终态【I->P->S->R】，且任意插入的事件并不会影响到这个流程。
     * ②若在一个正常的业务流程结束后，创建新的对象并再次执行一些事件，会发现状态机始终保持着终态【这个终态是第一个对象的事件流执行结束后的结果】。
     * ③若在执行事件之前就创建多个对象，且多个对象交叉执行事件，会发现状态机只是按照事件被调用的顺序来改变状态值，并不会理会是哪个对象的事件。
     * 3.若start、stop均不执行，则在sendEvent时会发生NullPointerException。
     * 通过以上可以发现，单例模式下的状态机是全局唯一的【每次调用的状态机的hashCode都是相同的】，在实际中无限接近于毫无用处。
     * 此时的改进思路是：实现在每次调用时，都能创建一个全新的状态机以供调用，这样可以避免受到前一个状态迁移的影响。
     * 【后话：使用单个状态机，但是每次调用前都使用所需要的状态覆盖当前状态，也可以避免受到前序影响】
     *
     * @param payInfo      将要执行状态变迁的实例
     * @param payEventEnum 执行的事件
     */
    public void exeChangeRepeatStart(Pay payInfo, PayEventEnum payEventEnum) {
        Message msg = MessageBuilder.withPayload(payEventEnum).setHeader("info", payInfo).build();
//        stateMachine.start();
        log.info("这个状态机的hashCode是{}", stateMachine.hashCode());
//        向状态机发送事件
        stateMachine.sendEvent(msg);
        log.info("状态机的状态{}", stateMachine.getState().getId());

//        stateMachine.stop();
    }
}
