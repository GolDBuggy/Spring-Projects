package com.hakki.demo.aop.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);

        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);

        boolean checked=true;
        Account account=new Account();
        account.setAddress("tuzla");
        account.setName("halil");
        accountDAO.addAccount(account,checked);
        accountDAO.addWork();
        accountDAO.setValue("ibo");


        System.out.println("-------------------------");
        System.out.println("Let's try again!");
        System.out.println("-------------------------");

        membershipDAO.addSillyAccount();
       membershipDAO.hello();
        context.close();
    }
}
