package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.Course;
import com.hakki.hibernate.demo.entity.Instructor;
import com.hakki.hibernate.demo.entity.InstructorDetail;
import com.hakki.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
        addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();

            Instructor instructor=new Instructor("benjamin","mikel","mrx@gmail.com");
            InstructorDetail instructorDetail=new InstructorDetail("germanHacker","penateration");
            Course course=new Course("etik hacker");
            Review review=new Review("harika bir egitim");
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);
            session.save(course);
            session.save(instructorDetail);
            course.setInstructor(instructor);
            course.add(review);



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
