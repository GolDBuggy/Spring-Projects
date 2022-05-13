package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).
                addAnnotatedClass(Student.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();

            Student student=session.get(Student.class,2);
            Course course=session.get(Course.class,11);
            student.addCourse(course);




            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
