package com.hakki.demo.aop.dao;

import java.io.IOException;

public class Account {

    String name;
    String address;




    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Account(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Account() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
