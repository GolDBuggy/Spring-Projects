package com.hakki.demo.aop.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan("com.hakki.demo.aop")
@EnableAspectJAutoProxy
@Configuration
public class DemoConfig {

}
