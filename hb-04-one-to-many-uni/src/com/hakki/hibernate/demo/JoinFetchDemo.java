package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.Course;
import com.hakki.hibernate.demo.entity.Instructor;
import com.hakki.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class JoinFetchDemo {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();
            int theId=1;

            Query<Instructor> query=session.createQuery("select i from Instructor i "+"JOIN FETCH i.course"+" where i.id=:theInstructorId",Instructor.class);

            query.setParameter("theInstructorId",theId);

            Instructor instructor= query.getSingleResult();

            System.out.println(instructor);

            session.getTransaction().commit();
            session.close();

            System.out.println(instructor.getCourse());


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
