package com.example.demo.Department;

import com.example.demo.Employee.Employee;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue
    @NotNull
    private Integer departmentId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String name;


}
