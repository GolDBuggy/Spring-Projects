package com.hakki.springboot.service;

import com.hakki.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public Employee getEmployee(int id);

    public void save(Employee employee);

    public void delete(int id);
}
