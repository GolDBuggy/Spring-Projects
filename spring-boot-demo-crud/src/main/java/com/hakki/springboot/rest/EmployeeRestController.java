package com.hakki.springboot.rest;

import com.hakki.springboot.entity.Employee;
import com.hakki.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    
    private EmployeeService employeeService;
    
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee=employeeService.getEmployee(employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
       // employee.setId(0);//if same data in database dont update the data
        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee delete(@PathVariable int employeeId){
        Employee employee=employeeService.getEmployee(employeeId);

        if(employee==null){
            throw new RuntimeException("This employee not found! -"+employeeId);
        }
        employeeService.delete(employeeId);
        return employee;
    }

}
