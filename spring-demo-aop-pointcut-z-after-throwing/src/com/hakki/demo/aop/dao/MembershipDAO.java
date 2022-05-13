package com.hakki.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyAccount(){
        System.out.println(getClass()+" DOING MY DB WORK!");

        return false;
    }

    public void hello(){
        System.out.println(getClass()+" DOING MY DB WORK!");

    }
}
