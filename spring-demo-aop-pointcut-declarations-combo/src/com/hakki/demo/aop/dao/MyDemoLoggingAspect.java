package com.hakki.demo.aop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
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

    //@Before("execution(* add*(com.hakki.demo.aop.dao.Account,..))")
    //@Before("execution(* add*(..))")
    //@Before("execution(* *(..))")
    @Before("forAddAccount()")
    public void beforeAddAccountLog(){
        System.out.println("====>>> Before advice Logging worked!");
    }

    @Before("forLastAccount() && !(getter() || setter())")
    public void beforeLastAccountLog(){
        System.out.println("====>>> Performing API worked!");
    }
}
