package com.hakki.demo.aop.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class accountAspectDemo {

    @Before("com.hakki.demo.aop.dao.MyDemoLoggingAspect.forAddAccountWithNoArgs()")
    public void output(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        System.out.println(getClass()+" Working!");
        System.out.println("Method: "+methodSignature);
    }

}
