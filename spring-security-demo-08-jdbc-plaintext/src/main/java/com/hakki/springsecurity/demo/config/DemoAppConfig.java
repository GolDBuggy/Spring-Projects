package com.hakki.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hakki.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {


    @Autowired
    private  Environment environment;

    private Logger logger=Logger.getLogger(getClass().getName());



    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();

        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }



    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource source=new ComboPooledDataSource();
        try {
            source.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        logger.info("jdbc info url >>>> "+environment.getProperty("jdbc.url"));
        logger.info("jdbc info name >>>> "+environment.getProperty("jdbc.user"));

        source.setJdbcUrl(environment.getProperty("jdbc.url"));
        source.setUser(environment.getProperty("jdbc.user"));
        source.setPassword(environment.getProperty("jdbc.password"));
        //
        source.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        source.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        source.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        source.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));


        return source;
    }

    private int getIntProperty(String prop){
        String str=environment.getProperty(prop);

        int result=Integer.parseInt(str);

        return result;
    }
}
