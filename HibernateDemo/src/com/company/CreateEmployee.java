package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateEmployee {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
                                                addAnnotatedClass(Employee.class).
                                                                buildSessionFactory();


        Session session=factory.getCurrentSession();

        try{
            Employee employee=new Employee("Yusuf","kilic","coban");
            session.beginTransaction();

            session.save(employee);
            System.out.println(employee);
            session.getTransaction().commit();



        }finally {
            factory.close();
        }

    }


}
