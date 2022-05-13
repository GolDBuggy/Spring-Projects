package com.hakki.springdemo.myproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class RestDemo {

    @GetMapping("/")
    public String home(){
        return "Welcome to Home page "+ LocalDateTime.now();
    }
}
