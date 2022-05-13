package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.Instructor;
import com.hakki.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();
           // int id=999;
            int theId=5;

            InstructorDetail instructorDetail=session.get(InstructorDetail.class,theId);

            System.out.println("Instructor detail is= "+instructorDetail);

            System.out.println("Instructor is= "+instructorDetail.getInstructor());


            session.save(instructorDetail);


            session.getTransaction().commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            //if we dont close session it can be memory leak
            session.close();
            factory.close();
        }
    }
}
