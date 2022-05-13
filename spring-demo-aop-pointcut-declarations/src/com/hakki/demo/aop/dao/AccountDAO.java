package com.hakki.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account,boolean checked){
        System.out.println(getClass()+" DOING MY DB WORK!");
    }

    public void addWork(){
        System.out.println(getClass()+" DOING MY DB WORK!");
    }

}
