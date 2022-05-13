package com.java.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.java.spring")
@PropertySource({"classpath:persistence-mysql.properties"})
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource source=new ComboPooledDataSource();

        try {
            source.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        source.setJdbcUrl(environment.getProperty("jdbc.url"));
        source.setUser(environment.getProperty("jdbc.user"));
        source.setPassword(environment.getProperty("jdbc.password"));
        source.setInitialPoolSize(convertType("connection.pool.initialPoolSize"));
        source.setMinPoolSize(convertType("connection.pool.minPoolSize"));
        source.setMaxPoolSize(convertType("connection.pool.maxPoolSize"));
        source.setMaxIdleTime(convertType("connection.pool.maxIdleTime"));


        return source;
    }


    private int convertType(String s){
        String str=environment.getProperty(s);
        int result=Integer.parseInt(str);
        return result;
    }

    private Properties getProperties(){
        Properties properties=new Properties();

        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getProperties());
        return  sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager manager=new HibernateTransactionManager();

        manager.setSessionFactory(sessionFactory);

        return manager;
    }
}
