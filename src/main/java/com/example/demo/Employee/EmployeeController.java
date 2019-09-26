package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private  final  EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.create(employeeDTO);
    }
    @GetMapping("/get-all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get-best-employee")
    public EmployeeDTO getBestPaidEmployee(){
        return employeeService.bestPaidEmployee();
    }

    @GetMapping("/get-all-women")
    public List<EmployeeDTO> getAllWomen (){
        return employeeService.getAllWomen();
    }

    @GetMapping("/get-all-men")
    public List<EmployeeDTO> getAllMen (){
        return employeeService.getAllMen();
    }

    @GetMapping("/login")
    public EmployeeDTO login(@RequestParam String email, @RequestParam String password){
        return employeeService.getEmployeeByCredentials(email,password);
    }
}
