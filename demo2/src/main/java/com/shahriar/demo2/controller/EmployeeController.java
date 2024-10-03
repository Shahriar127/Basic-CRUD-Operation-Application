package com.shahriar.demo2.controller;

import com.shahriar.demo2.annotations.ApiController;
import com.shahriar.demo2.model.Employee;
import com.shahriar.demo2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) { this.employeeService = employeeService;}


    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee) { return employeeService.updateEmployee(employee);}

    @PostMapping("/create")
    public Employee save(@RequestBody Employee employee) { return employeeService.savaEmployee(employee);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) { employeeService.deleteEmployee(id);}

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) { return (Employee) employeeService.getAllEmployees(id);}

    @GetMapping("/all")
    public List<Employee> getAllEmployees() { return employeeService.getAllEmployees(Long.MAX_VALUE);}

}



