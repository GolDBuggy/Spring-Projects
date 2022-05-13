package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//  eğer lazy yaparsak isteğe bağlı çağırcağı için hata verir ama eager yaparsak direk bağlantısı olan bütün istekleri çağırcağı için session kapalıda olsa gelir
public class GetDemo {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).
                addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId=1;


            Student student=session.get(Student.class,theId);

            System.out.println(student+"\n"+student.getCourses());

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
