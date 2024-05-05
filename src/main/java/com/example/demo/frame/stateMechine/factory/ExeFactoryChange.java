package com.example.demo.frame.stateMechine.factory;

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
 * @Date 2024/5/2 11:49
 * @Description TODO
 */

@Slf4j
@Component
public class ExeFactoryChange {

    @Autowired
    PayFactoryStateMachineBuilder builder;

    @Autowired
    BeanFactory beanFactory;

    @Autowired
    StateMachine<PayStateEnum, PayEventEnum> stateMachine;

    /**
     * 第二话
     * 使用builder，就可以实现多个状态机。
     * 1.连续调用本方法，会发现每次调用的状态机的hashCode都不一样，这说明确实在每次执行时都创建了新的状态机。
     * 2.在本方法中，由于每次都创建新的状态机，所以是否调用stop对于下一次调用本方法没有影响。【所以选择不调用】
     * 3.类似的，每次调用start都会创建新的状态机，状态机的当前状态自然也是定义中的初始状态。
     * 验证方法：随意地创建对象，随意地执行事件。
     * 执行结果：虽然每次执行都不再受其他事件和状态机的影响，但是调用start本质上还是初始化了状态机，所以此时只能实现从定义的初始状态为初始状态的事件。
     * 至此，实现了在每一次调用本方法时都创建一个新的状态机，即，在业务处理过程中，每次的业务处理状态变化都不受前序事件的影响。
     * 但是，实际运用中，业务对象的状态流转是一个比较长的链路，即初始状态和终态之间还会有许多状态存在。
     * 现在需要解决的问题是，在调用状态机时，如何使得状态机的当前状态是所需要的任一状态而不是定义好的初始状态。
     * 【这个问题的前提是，在定义状态机的时候，就使用initial()定义了状态机的初始状态，类似于一个写死的值，在运行时并不能改变；并且也不能不定义初始值。】
     *
     * @param payInfo      将要执行状态变迁的实例
     * @param payEventEnum 事件
     * @throws Exception
     */
    public void exeChangeCreateSm(Pay payInfo, PayEventEnum payEventEnum) throws Exception {
        Message msg = MessageBuilder.withPayload(payEventEnum).setHeader("info", payInfo).build();
        stateMachine = builder.build(beanFactory);
        stateMachine.start();
        log.info("这个状态机的hashCode是{}", stateMachine.hashCode());
        stateMachine.sendEvent(msg);
        log.info("状态机的状态{}", stateMachine.getState().getId());
    }


    @Resource(name = "payPersister")
    private StateMachinePersister<PayStateEnum, PayEventEnum, Pay> persister;

    /**
     * 第三话
     * 初始值不能改变，但是当前状态可以改变。
     * 1.调用此方法，分别输出恢复状态前后的状态值。
     * 验证过程：此处就不要把业务状态定义成和状态机初始化状态一致的状态了，避免值一样，看不出变化。
     * 执行结果：状态机的状态值在初始化时为定义的初始化值，在执行restore之后，变化为业务对象的状态值。
     * 2.增加执行sendEvent方法，此时需要注意，业务对象的当前状态要和执行的事件匹配，不然执行不到业务处理方法。
     * 3.需要注意的是，状态机处理的业务对象的状态值必须和枚举值保持一致（在equal层面而不是状态含义层面）。
     * 到此，业务对象实现了可以从任意的当前状态经过相应的事件变迁到目的状态。
     * 以上几乎仅适用于有向无环的状态机；在实际中，会有分支、状态回溯等情况需要处理，此时若对每一种状态变迁都定义一个事件，显然是不够优雅的。
     *
     * @param payInfo      将要执行状态变迁的实例
     * @param payEventEnum 事件
     */
    public void exeChangeFromDifferentState(Pay payInfo, PayEventEnum payEventEnum) throws Exception {
        payInfo.setPaySts(findName(payInfo.getPaySts()));

        Message msg = MessageBuilder.withPayload(payEventEnum).setHeader("info", payInfo).build();
        stateMachine = builder.build(beanFactory);
        stateMachine.start();
        log.info("初始换的状态是【{}】", stateMachine.getState().getId());
        //恢复
        persister.restore(stateMachine, payInfo);
        log.info("恢复后的状态是【{}】", stateMachine.getState().getId());

        stateMachine.sendEvent(msg);
        log.info("sendEvent之后的状态值是【{}】", stateMachine.getState().getId());
    }


}
