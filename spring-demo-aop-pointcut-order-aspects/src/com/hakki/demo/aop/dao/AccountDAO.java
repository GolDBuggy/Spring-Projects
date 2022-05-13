package com.hakki.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    String value;

    public String getValue() {
        System.out.println("Getting value!");
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        System.out.println("Value successfully setted!");
    }

    public void addAccount(Account account, boolean checked){
        System.out.println(getClass()+" DOING MY DB WORK!");
    }

    public void addWork(){
        System.out.println(getClass()+" DOING MY DB WORK!");
    }

}
