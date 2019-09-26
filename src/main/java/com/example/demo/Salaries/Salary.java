package com.example.demo.Salaries;

import com.example.demo.Employee.Employee;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "salaries")
public class Salary implements Serializable {

    @Id
    @GeneratedValue
    @NotNull
    private Integer salaryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date fromDate;
    private Date toDate;
    private Long salary;
}
