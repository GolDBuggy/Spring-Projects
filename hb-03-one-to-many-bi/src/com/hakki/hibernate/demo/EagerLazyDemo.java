package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.Course;
import com.hakki.hibernate.demo.entity.Instructor;
import com.hakki.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//  eğer lazy yaparsak isteğe bağlı çağırcağı için hata verir ama eager yaparsak direk bağlantısı olan bütün istekleri çağırcağı için session kapalıda olsa gelir
public class EagerLazyDemo {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();
            // int id=999;
            int theId=1;

            Instructor instructor=session.get(Instructor.class,theId);
            System.out.println("Instructor detail is= "+instructor);
            session.getTransaction().commit();
            session.close();

            System.out.println("Instructor is= "+instructor.getCourse());




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
