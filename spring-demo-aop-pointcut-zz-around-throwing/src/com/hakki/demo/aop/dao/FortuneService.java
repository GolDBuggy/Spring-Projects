package com.hakki.demo.aop.dao;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class FortuneService {

    public String getFortune(){

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
          e.printStackTrace();
        }


        return "happy fortune service :)";
    }


    public String getName(){


        return "what the fuck is the return value?! ";
    }


    public String getExc(boolean key)  {

        if(key){
            throw new RuntimeException("Corba yok sana :)");
        }
        else
            return "hata cikmadi iyisin :D";
    }
}
