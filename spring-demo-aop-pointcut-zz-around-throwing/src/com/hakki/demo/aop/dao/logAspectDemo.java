package com.hakki.demo.aop.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class logAspectDemo {

    @Before("execution(* com.hakki.demo.aop.dao.*.*(..))")
    public void output(JoinPoint joinPoint){
        System.out.println(getClass()+" Working!");

        Object[] args= joinPoint.getArgs();

        for (Object a:args) {
            System.out.println(a);

            if( a instanceof Account){
                Account account=(Account) a;

                System.out.println(account.getAddress());
                System.out.println(account.getName());

            }

        }
    }
}
