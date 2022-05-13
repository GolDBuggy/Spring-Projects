package com.hakki.demo.aop.dao;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    String value;


    public List<Account> myAccounts(boolean key) {

        List<Account> accounts=new ArrayList<>();

        if(key){
            throw new RuntimeException("Çorba yok sana :)");
        }


        Account account=new Account("ibo","darıca");
        Account account1=new Account("halil","tuzla");
        Account account2=new Account("nursel","ardahan");

        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);

        return  accounts;
    }

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
