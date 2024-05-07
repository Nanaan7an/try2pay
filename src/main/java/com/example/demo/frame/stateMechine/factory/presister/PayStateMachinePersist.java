package com.example.demo.frame.stateMechine.factory.presister;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.pojo.Pay;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Component;

/**
 * @Author Nanaan
 * @Date 2024/5/2 13:41
 * @Description 实现一下持久化，但是什么也不干，主要是为了取一个任何状态节点的状态机。
 * StateMachinePersist本来是用于管理状态机的当前状态，并持久化至本地；当发生意外时，可以从本地缓存中读取并恢复之前的状态。
 * 但在这里，并不是为了持久化，因为这种持久化也不可靠；此处仅仅是为了在执行时可以重置状态机的当前状态，重置为业务对象的当前状态。
 */

@Component
public class PayStateMachinePersist implements StateMachinePersist<PayStateEnum, PayEventEnum, Pay> {
    /*
    优化建议：
    将最后一个泛型改为状态枚举类型，这样可以使得在重置状态机状态时，传入的参数类型为.restore(stateMachine, StateEnum)。
    这样做的好处是，避免限制了重置状态时的业务对象类型。
    如，POJO1和POJO2都有状态值使用了PayStateEnum，此举可以使得POJO1和POJO2可以公用本状态机。若指定了实体类类型，则不具有普适性。
     */
//public class PayStateMachinePersist implements StateMachinePersist<PayStateEnum, PayEventEnum, PayStateEnum> {
    @Override
    public void write(StateMachineContext<PayStateEnum, PayEventEnum> context, Pay contextObj) throws Exception {
        //这里不做任何持久化工作
    }

    @Override
    public StateMachineContext<PayStateEnum, PayEventEnum> read(Pay contextObj) throws Exception {
        StateMachineContext<PayStateEnum, PayEventEnum> result = new DefaultStateMachineContext<PayStateEnum, PayEventEnum>(
                PayStateEnum.valueOf(contextObj.getPaySts()), null, null, null, null, "payFactory");
        return result;
    }

}
