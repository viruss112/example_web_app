package com.example.demo.Department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public DepartmentDTO createDepartment ( @RequestBody DepartmentDTO departmentDTO){
        return departmentService.create(departmentDTO);
    }

    @GetMapping("/get-departments")
    public List<DepartmentDTO>  getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/get-popular")
    public DepartmentDTO getPopular(){
        return departmentService.popularDepartment();
    }
}
