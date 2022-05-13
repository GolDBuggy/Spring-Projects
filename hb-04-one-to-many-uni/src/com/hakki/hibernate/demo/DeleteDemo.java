package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.Course;
import com.hakki.hibernate.demo.entity.Instructor;
import com.hakki.hibernate.demo.entity.InstructorDetail;
import com.hakki.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
                                        addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).
                                            addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

        Session session=factory.getCurrentSession();


        try{
            session.beginTransaction();
            int theId=11;
            Course course=session.get(Course.class,theId);
            System.out.println(course);
            System.out.println(course.getReviews());
            session.delete(course);
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
