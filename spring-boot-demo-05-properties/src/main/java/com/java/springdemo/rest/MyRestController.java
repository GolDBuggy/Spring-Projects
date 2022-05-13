package com.java.springdemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @Value("${team.total.win}")
    private int teamWin;

    @GetMapping("/")
    public String home(){
        return "Welcome home page, time --> "+ LocalDateTime.now();
    }

    @GetMapping("/devtool")
    public String tryDevtool(){
        return "devtool worked :)";
    }

    @GetMapping("/values")
    public String getPropVal(){
        return "Coach name= "+coachName+", Team Name= "+teamName+", Total Team Win= "+teamWin;
    }



}
