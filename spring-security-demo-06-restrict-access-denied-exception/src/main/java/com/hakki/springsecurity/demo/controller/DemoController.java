package com.hakki.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaderPage(){
        return "leaders-page";
    }

    @GetMapping("/systems")
    public String showSystemPage(){
        return "system-page";
    }
}
