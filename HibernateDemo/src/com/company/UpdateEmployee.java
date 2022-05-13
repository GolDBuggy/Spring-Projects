package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateEmployee {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{

            session.beginTransaction();

            session.createQuery("update  Employee set company='emlakjet' where firstName='ibrahim'"+" OR id=6").executeUpdate();


            session.getTransaction().commit();

            session=factory.getCurrentSession();
            session.beginTransaction();
            int id=6;
            Employee employee=session.get(Employee.class,id);
            employee.setLastName("Yilmaz");

            session.getTransaction().commit();




        }finally {
            factory.close();
        }



    }
}
