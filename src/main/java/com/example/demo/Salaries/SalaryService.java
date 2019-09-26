package com.example.demo.Salaries;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository, ModelMapper modelMapper) {
        this.salaryRepository = salaryRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public SalaryDTO createSalary(SalaryDTO salaryDTO) {

        Salary salary = new Salary();
        modelMapper.map(salaryDTO, salary);
        Salary savedSalary = salaryRepository.save(salary);
        SalaryDTO salaryDTO1 = new SalaryDTO();
        modelMapper.map(savedSalary, salaryDTO1);
        return salaryDTO1;

    }

    @Transactional
    public List<SalaryDTO> getAllSalaries() {
        List<Salary> salaryList = new ArrayList<>();
        salaryList = (List<Salary>) salaryRepository.findAll();
        List<SalaryDTO> salaryDTOList = new ArrayList<>();
        for (Salary salary : salaryList) {
            SalaryDTO salaryDTO = new SalaryDTO();
            modelMapper.map(salary, salaryDTO);
            salaryDTOList.add(salaryDTO);
        }
        return salaryDTOList;
    }

    @Transactional
    public List<SalaryDTO> getSalariesByEmployeeId(Integer employeeId) {

        List<Salary>  salaryList = salaryRepository.getSalariesByEmployeeId(employeeId);
        List<SalaryDTO> salaryDTOList = new ArrayList<>();
        for (Salary salary : salaryList) {
            SalaryDTO salaryDTO = new SalaryDTO();
            modelMapper.map(salary, salaryDTO);
            salaryDTOList.add(salaryDTO);

        }
        return salaryDTOList;

    }


}
