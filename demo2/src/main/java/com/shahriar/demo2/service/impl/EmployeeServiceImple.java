package com.shahriar.demo2.service.impl;

import com.shahriar.demo2.model.Employee;
import com.shahriar.demo2.repository.EmployeeRepository;
import com.shahriar.demo2.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImple implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImple(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee savaEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById((long) id).get();
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> getAllEmployees(Long id) {
        List<Employee> employeelist = employeeRepository.findAll();
        return employeelist;
    }

    @Override
    public List<Employee> getA(Long id) {
        return employeeRepository.findById(id)
                .map(List::of)
                .orElse(List.of());
    }



}
