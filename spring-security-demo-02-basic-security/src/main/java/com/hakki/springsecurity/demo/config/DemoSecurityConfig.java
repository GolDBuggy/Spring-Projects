package com.hakki.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder= User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(userBuilder.username("ibrahim").password("test123").roles("EMPLOYEE")).
                withUser(userBuilder.username("halil").password("test321").roles("MANAGER")).
                withUser(userBuilder.username("meryem").password("test123").roles("ADMIN"));

    }


}
