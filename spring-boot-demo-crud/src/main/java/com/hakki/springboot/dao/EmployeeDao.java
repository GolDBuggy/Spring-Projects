package com.hakki.springboot.dao;

import com.hakki.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployee();

    public Employee getEmployee(int id);

    public void save(Employee employee);

    public void delete(int id);
}
