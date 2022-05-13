package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadEmployee {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();


        try{
           int id=1;
            session.beginTransaction();

            Employee employee=session.get(Employee.class,id);
            System.out.println(employee);
            session.getTransaction().commit();
            session= factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employees=session.createQuery("from Employee").getResultList();
            lists(employees);

            session.getTransaction().commit();



        }finally {
            factory.close();
        }
    }

    public static void lists(List<Employee> employees){
        for (Employee e: employees) {
            System.out.println(e);
        }
    }
}
