package com.hakki.demo.aop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

   /* @Before("execution(public void com.hakki.demo.aop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountLog(){
        System.out.println("====>>> Before addAccount Logging worked!");
    }*/

    //@Before("execution(* add*(com.hakki.demo.aop.dao.Account,..))")
    //@Before("execution(* add*(..))")
    //@Before("execution(* *(..))")
    @Before("execution(* com.hakki.demo.aop.dao.*.*(..))")
    public void beforeAddAccountLog(){
        System.out.println("====>>> Before advice Logging worked!");
    }
}
