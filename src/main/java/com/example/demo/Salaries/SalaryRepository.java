package com.example.demo.Salaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends CrudRepository<Salary,Integer> {

    @Query(value = "select * from salaries where employee_id=:employeeId",nativeQuery = true)
    List<Salary> getSalariesByEmployeeId(@Param("employeeId") Integer employeeId);
}
