package com.example.demo.Department;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {

    @Query(value = " select *, count(d.department_id)  as num from appdatabase.departments d group by name order by num desc ",nativeQuery = true)
    List<Department> popularDepartment();
}
