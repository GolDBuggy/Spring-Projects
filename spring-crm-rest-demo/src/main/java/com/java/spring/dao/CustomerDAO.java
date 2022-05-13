package com.java.spring.dao;

import com.java.spring.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public Customer getCustomer(int id);

    public void saveCustomer(Customer customer);

    public void deleteCustomer(Customer customer);
}
