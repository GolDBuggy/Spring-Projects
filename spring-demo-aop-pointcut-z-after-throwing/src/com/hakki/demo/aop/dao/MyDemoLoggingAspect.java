package com.hakki.demo.aop.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Order(3)
public class MyDemoLoggingAspect {

   /* @Before("execution(public void com.hakki.demo.aop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountLog(){
        System.out.println("====>>> Before addAccount Logging worked!");
    }*/

    @Pointcut("execution(* com.hakki.demo.aop.dao.*.*(..))")
    private void forAddAccount(){}

    @Pointcut("execution(* com.hakki.demo.aop.dao.AccountDAO.*())")
    private void forLastAccount(){}

    @Pointcut("execution(* com.hakki.demo.aop.dao.*.set*(..))")
    private void getter(){}

    @Pointcut("execution(* com.hakki.demo.aop.dao.*.get*(..))")
    private void setter(){}

    @Pointcut("forLastAccount() && !(getter() || setter())")
    public void forAddAccountWithNoArgs(){}

    //@Before("execution(* add*(com.hakki.demo.aop.dao.Account,..))")
    //@Before("execution(* add*(..))")
    //@Before("execution(* *(..))")
    @Before("forAddAccount()")
    public void beforeAddAccountLog(){
        System.out.println("====>>> Before advice Logging worked!");
    }

    @Before("forAddAccountWithNoArgs()")
    public void beforeLastAccountLog(){
        System.out.println("====>>> Performing API worked!");
    }

    @AfterReturning(pointcut = "execution(* com.hakki.demo.aop.dao.AccountDAO.myAccounts(..))",returning = "result")
    public void afterReturn(JoinPoint joinPoint, List<Account> result){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        System.out.println("After returning method activated!");
        System.out.println("method= "+methodSignature);
    }
}
