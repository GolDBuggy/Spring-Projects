package com.java.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String home(){
        return "Welcome home page, time --> "+ LocalDateTime.now();
    }

    @GetMapping("/devtool")
    public String tryDevtool(){
        return "devtool worked :)";
    }



}
