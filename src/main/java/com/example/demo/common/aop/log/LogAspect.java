package com.example.demo.common.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
     * 切点
     * 1.仅使用AOP时，切点的参数值为所有加强点的匹配的路径表达式
     * 2.AOP+自定义注解：参数值为自定义注解的包路径，使用了自定义注解的类/方法均为连接点
     */
    @Pointcut(value = "@annotation(com.example.demo.common.aop.log.Log)")
    public void pt() {
    }

    /**
     * 通知
     * 1.使用注解指定通知的时机；
     * 2.在定义通知方法的时候，一般可以使用 JoinPoint 作为参数，用于访问当前连接点，获取方法名、参数等
     */

    //前置通知，连接点执行前执行
    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("{}的前置通知", joinPoint.getSignature().getName());
    }

    //后置通知，连接点正常/异常执行结束后执行
    @After("pt()")
    public void after(JoinPoint joinPoint) {
        log.info("{}的后置通知", joinPoint.getSignature().getName());
    }

    /**
     * @param joinPoint ProceedingJoinPoint仅能在@Around中使用
     * @return
     * @throws Throwable
     */
    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("{}的环绕通知", joinPoint.getSignature().getName());

        //执行方法/启动连接点
        Object jsonResult = joinPoint.proceed();

        //获取切入点的签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取注解值
        Log annotation = method.getAnnotation(Log.class);
        String title = annotation.value();
        log.info("注解值是{}", title);

        // 获取传入目标方法的参数，返回一个数组
        Object[] args = joinPoint.getArgs();
        log.info("参数:{}", args);

        return jsonResult;
    }

    //返回通知，仅在连接点正常返回后执行，此时可以获取连接点的返回值
    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Log controllerLog, Object result) {
        log.info("{}的返回通知，返回值：{}", joinPoint.getSignature().getName(), result);
    }

    //异常通知，仅在连接点抛出异常时执行
    @AfterThrowing(pointcut = "pt()",throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        log.info("{}的异常通知，异常信息：", joinPoint.getSignature().getName(), error);
    }
}
