package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session= factory.getCurrentSession();

        try {
            int id=5;
            session.beginTransaction();
          /*  Employee employee=session.get(Employee.class,id);
            session.delete(employee);
*/

            session.createQuery("delete from Employee  where id=7").executeUpdate();
            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }
}
