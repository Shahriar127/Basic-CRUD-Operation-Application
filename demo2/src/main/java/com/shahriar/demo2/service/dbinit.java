package com.shahriar.demo2.service;

import com.shahriar.demo2.model.Address;
import com.shahriar.demo2.model.Employee;
import com.shahriar.demo2.repository.AddressRepository;
import com.shahriar.demo2.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class dbinit {
    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    public dbinit(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    //@PostConstruct
    public void init() {
        try {
            // Creating and setting values for Address entity
            Address address = new Address();
            address.setCity("Dhaka");
            address.setCountry("Bangladesh");

            // Saving Address entity to the database
            address = addressRepository.save(address);

            // Creating and setting values for Employee entity
            Employee employee = new Employee();
            employee.setName("Shahriar");
            employee.setAddress(address);  // Assuming it's a single Address field

            // Saving Employee entity to the database
            employee = employeeRepository.save(employee);

            // Output Employee and Address IDs to verify
            System.out.println("E ID: " + employee.getId());
            System.out.println("A ID: " + address.getId());
        } catch (Exception e) {
            System.out.println("Error during initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
