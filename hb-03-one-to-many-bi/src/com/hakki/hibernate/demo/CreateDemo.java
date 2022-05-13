package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.Course;
import com.hakki.hibernate.demo.entity.Instructor;
import com.hakki.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();

          Instructor instructor=new Instructor("nursel","kilic","nursel@gmail.com");

           InstructorDetail instructorDetail=new InstructorDetail("megri","music");

            Course course=new Course("Music for kurdish");

            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);
            course.setInstructor(instructor);

           session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}

/*
    int id=1;

      Instructor instructor1=session.get(Instructor.class,id);

            InstructorDetail instructorDetail1=session.get(InstructorDetail.class,3);
            instructor1.setInstructorDetail(instructorDetail1);

 */
