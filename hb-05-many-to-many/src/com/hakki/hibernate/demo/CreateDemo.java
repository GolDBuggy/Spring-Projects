package com.hakki.hibernate.demo;

import com.hakki.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
        addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();

            Course course=new Course("Python for beginners");
            Course course1=new Course("Data science in IBM");

            Student student=new Student("ibrahim","kilic","ibo@gmail.com");
            Student student1=new Student("halil","kilic","halil@gmail.com");

            session.save(course);
            session.save(course1);
            session.save(student);
            session.save(course);

            course.addStudent(student);
            course.addStudent(student1);
            course1.addStudent(student);

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
