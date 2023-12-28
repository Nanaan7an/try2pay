package com.example.demo.common.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*
@Aspect、@Component标识一个切面类；
@Order(int)标识切面的执行优先级，值小的优先级高。
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class LogAspect {
    /**
     * 定义一个切点com/example/demo/common/log/LogAnnotation.java
     */
    @Pointcut(value = "@annotation(com.example.demo.common.log.LogAnnotation)")
    public void pointCut(){}

    /**
     * 在定义通知方法的时候，一般可以使用 JoinPoint 作为参数
     */
    @Before("pointCut()")
    public void beforePc(JoinPoint joinPoint){
        log.info("这是切面的前置通知");
    }


    @Around("pointCut()")
    public Object aroundPc(ProceedingJoinPoint joinPoint) throws Throwable {
        Object jsonResult = joinPoint.proceed(); //执行方法
        log.info("这是切面的环绕通知");
        //获取请求签名
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取注解值
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String title=annotation.title();
        log.info("注解值是{}",title);

        return jsonResult;
    }
}
