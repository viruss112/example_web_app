package com.example.demo.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {


    @Query(value = "select * from appdatabase.employees  inner join appdatabase.salaries  on employees.employee_id= salaries.employee_id  and  salaries.salary in (select max(s.salary) from appdatabase.salaries s)", nativeQuery = true)
    List<Employee> bestEmployee();

    @Query (value="select * from employees where gender like 'F' ", nativeQuery = true)
    List<Employee> women();

    @Query (value="select * from employees where gender like 'M' ", nativeQuery = true)
    List<Employee> men();

    @Query (value = "select * from employees where email =:emailUser and password =:passwordUser ",nativeQuery = true)
    Employee getEmployeeByCredentials(@Param("emailUser") String emailUser , @Param("passwordUser") String passwordUser);

}

