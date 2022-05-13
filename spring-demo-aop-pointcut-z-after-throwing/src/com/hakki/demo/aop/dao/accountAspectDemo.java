package com.hakki.demo.aop.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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


    @AfterThrowing(pointcut = "execution(* com.hakki.demo.aop.dao.AccountDAO.myAccounts(..))",throwing = "exception")
    public void afterThrow(JoinPoint joinPoint,RuntimeException exception){

        System.out.println("AFTER THROWING METHOD WORKED!");
        System.out.println("EXCEPTION = "+exception);

    }




}
