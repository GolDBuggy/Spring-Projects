package com.hakki.springboot.dao;

import com.hakki.springboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session=entityManager.unwrap(Session.class);//sessionFactory.getCurrentSession();
        Query<Employee> query=session.createQuery("from Employee",Employee.class);
        List<Employee> employees=query.getResultList();
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session=entityManager.unwrap(Session.class);
        Employee employee=session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Session session=entityManager.unwrap(Session.class);
        Query query=session.createQuery("delete from Employee where id=:theId");
        query.setParameter("theId",id);
        query.executeUpdate();
    }
}
