package com.example.demo.Salaries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    private final SalaryService salaryService;
    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping("/create")
    public SalaryDTO createSalary(@RequestBody SalaryDTO salaryDTO){
        return salaryService.createSalary(salaryDTO);

    }
    @GetMapping("/get-all")
    public List<SalaryDTO> getAllSalaries(){
        return salaryService.getAllSalaries();
    }
    @GetMapping("/get/{employeeId}")
    public List<SalaryDTO> getSalariesByEmployeeId( @PathVariable Integer employeeId){
        return salaryService.getSalariesByEmployeeId(employeeId);
    }
}
