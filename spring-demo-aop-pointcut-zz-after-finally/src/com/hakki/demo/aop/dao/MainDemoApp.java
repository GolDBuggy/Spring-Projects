package com.hakki.demo.aop.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class MainDemoApp {

    private static Logger logger=Logger.getLogger(MainDemoApp.class.getName());

    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        FortuneService fortuneService=context.getBean("fortuneService",FortuneService.class);

        logger.info("Main program Around Demo App");

        logger.info("Calling getFortune!");

        logger.info("\n ---------------------------------------------------------- \n");

        String data=fortuneService.getFortune();

        logger.info(data);

        logger.info("Final");

        logger.info("\n ---------------------------------------------------------- \n");

        logger.info(fortuneService.getName());

        context.close();
    }
}
