package com.java.spring.rest;

import com.java.spring.entity.Customer;
import com.java.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer=customerService.getCustomer(customerId);

        if(customer == null ){
            throw new CustomerNotFoundException("Customer not found! -"+customerId);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);//hibernate saveorupdate method see the customer id is empty and insert the method
        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer=customerService.getCustomer(customerId);

        if(customer == null){
            throw new CustomerNotFoundException("Customer not found! -"+customerId);
        }

        customerService.deleteCustomer(customer);

        return "Customer Successfully Deleted! -"+customerId;
    }
}
