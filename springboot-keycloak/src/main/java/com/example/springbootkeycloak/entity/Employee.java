package com.example.springbootkeycloak.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double salary;

    public Employee(String name, double salary)
    {
        this.name=name;
        this.salary=salary;
    }
}
