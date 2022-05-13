package com.java.spring.service;


import com.java.spring.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomer(int id);

    public void saveCustomer(Customer customer);

    public void deleteCustomer(Customer customer);
}
