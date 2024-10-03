package com.shahriar.demo2.service;

import com.shahriar.demo2.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee savaEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long employee);
    List<Employee> getAllEmployees(Long id);
    List<Employee> getA(Long id);
}
