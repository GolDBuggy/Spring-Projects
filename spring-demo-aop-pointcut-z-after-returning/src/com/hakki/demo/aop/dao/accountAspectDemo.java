package com.hakki.demo.aop.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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


    @AfterReturning(pointcut = "execution (* com.hakki.demo.aop.dao.AccountDAO.myAccounts(..))",returning = "accounts")
    public void returnValue(JoinPoint joinPoint, List<Account> accounts){

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        System.out.println("Method ==> "+methodSignature);
        System.out.println("List now ==> "+accounts);

        lowerToUpperCase(accounts);

        System.out.println("New List type now ==> "+accounts);

    }

    private void lowerToUpperCase(List<Account> accounts) {
        for (Account a: accounts) {
            String name=a.getName().toUpperCase();
            a.setName(name);
        }
    }

    @AfterReturning(pointcut = "execution(* com.hakki.demo.aop.dao.AccountDAO.myAccounts(..))",returning = "accounts")
    public void aspectSelections(JoinPoint joinPoint,List<Account> accounts){
        System.out.println("\n ----------------------------------------------- \n");
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date= dateTime.format(formatter);

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

        System.out.println("List => "+accounts+"\n"+" Method => "+methodSignature+"\n"+" loggind time => "+date);


    }

}
