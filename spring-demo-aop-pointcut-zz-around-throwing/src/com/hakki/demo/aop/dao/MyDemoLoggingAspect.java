package com.hakki.demo.aop.dao;

import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Component
@Aspect
@Order(3)
public class MyDemoLoggingAspect {


    private Logger logger=Logger.getLogger(MyDemoLoggingAspect.class.getName());

    /* @Before("execution(public void com.hakki.demo.aop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountLog(){
        logger.info("====>>> Before addAccount Logging worked!");
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
        logger.info("====>>> Before advice Logging worked!");
    }

    @Before("forAddAccountWithNoArgs()")
    public void beforeLastAccountLog(){
        logger.info("====>>> Performing API worked!");
    }

    @AfterReturning(pointcut = "execution(* com.hakki.demo.aop.dao.AccountDAO.myAccounts(..))",returning = "result")
    public void afterReturn(JoinPoint joinPoint, List<Account> result){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        logger.info("After returning method activated!");
        logger.info("method= "+methodSignature);
    }


    @After("execution(* com.hakki.demo.aop.dao.AccountDAO.myAccounts(..))")
    public void afterFinallyAdvice(JoinPoint joinPoint){

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        logger.info("After Finally Working!");
        logger.info("Method: "+methodSignature);
    }


    @Around("execution(* com.hakki.demo.aop.dao.FortuneService.getExc(..))")
    public Object aroundWork(ProceedingJoinPoint proceedingJoinPoint )throws Throwable {

        MethodSignature methodSignature=(MethodSignature) proceedingJoinPoint.getSignature();
        logger.info("@Around method working!");
        logger.info("method = "+methodSignature);

        Object result=null;

        try{

            result=proceedingJoinPoint.proceed();
        }catch (RuntimeException ex){
           logger.info(ex.getMessage());
            result="hata ciktiysa uzulme,hatayı cozmeye odaklan :)";

            //throw ex;
        }



        return result;
    }
}
