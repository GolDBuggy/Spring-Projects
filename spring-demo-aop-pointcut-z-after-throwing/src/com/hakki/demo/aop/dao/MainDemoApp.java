package com.hakki.demo.aop.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class MainDemoApp {

    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);

        try {
            List<Account> accounts = accountDAO.myAccounts(true);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }



        context.close();
    }
}
