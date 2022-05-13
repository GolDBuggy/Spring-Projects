package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.Course;
import com.hakki.hibernate.demo.entity.Instructor;
import com.hakki.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();

            Instructor instructor =session.get(Instructor.class,1);

           Course course=new Course("KickBox");
            session.save(course);
         course.setInstructor(instructor);

           //InstructorDetail instructorDetail=session.get(InstructorDetail.class,1);

           // instructor.setInstructorDetail(instructorDetail);
            //InstructorDetail instructorDetail=session.get(InstructorDetail.class,7);

          //  instructor.setInstructorDetail(instructorDetail);



            //  session.save(instructor);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
