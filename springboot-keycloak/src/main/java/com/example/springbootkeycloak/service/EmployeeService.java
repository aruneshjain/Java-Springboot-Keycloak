package com.example.springbootkeycloak.service;

import com.example.springbootkeycloak.entity.Employee;
import com.example.springbootkeycloak.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void InitializedEmployeeTable(){
        employeeRepository.saveAll(
                Stream.of(
                        new Employee("Arunesh",50000),
                        new Employee("Surbhi",80000),
                        new Employee("Shivani",82000)
                ).collect(Collectors.toList()));
    }

    public Employee getEmployee(int employeeId)
    {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
