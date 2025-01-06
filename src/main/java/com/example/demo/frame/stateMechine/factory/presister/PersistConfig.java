package com.example.demo.frame.stateMechine.factory.presister;

import com.example.demo.frame.stateMechine.PayEventEnum;
import com.example.demo.frame.stateMechine.PayStateEnum;
import com.example.demo.pojo.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

/**
 * @Author Nanaan
 * @Date 2024/5/2 13:44
 * @Description 转换成StateMachinePersister。
 * StateMachinePersister是可以直接保存StateMachine对象的，所以我们需要先继承StateMachinePersist，然后在Config类里面转换成StateMachinePersiste
 */
@Configuration
public class PersistConfig {
    @Autowired
    private PayStateMachinePersist persist;

    @Bean(name = "payPersister")
    public StateMachinePersister<PayStateEnum, PayEventEnum, Pay> orderPersister() {
        return new DefaultStateMachinePersister<PayStateEnum, PayEventEnum, Pay>(persist);
    }
}