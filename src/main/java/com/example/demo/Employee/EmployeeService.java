package com.example.demo.Employee;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public EmployeeDTO create(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        EmployeeDTO employeeDTO1 = new EmployeeDTO();
        modelMapper.map(employeeDTO, employee);
        Employee savedEmployee = employeeRepository.save(employee);
        modelMapper.map(savedEmployee, employeeDTO1);
        return employeeDTO1;

    }
    @Transactional
    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            modelMapper.map(employee, employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Transactional
    public EmployeeDTO bestPaidEmployee(){
        List<Employee> employeeList = employeeRepository.bestEmployee();
        Employee bestEmployee=employeeList.get(0);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        modelMapper.map(bestEmployee,employeeDTO);
        return employeeDTO;
    }

    @Transactional
    public List<EmployeeDTO> getAllWomen() {
        List<Employee> employeeList = employeeRepository.women();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for(Employee employee : employeeList){
            EmployeeDTO employeeDTO = new EmployeeDTO();
            modelMapper.map(employee,employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }
    @Transactional
    public List<EmployeeDTO> getAllMen() {
        List<Employee> employeeList = employeeRepository.men();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for(Employee employee : employeeList){
            EmployeeDTO employeeDTO = new EmployeeDTO();
            modelMapper.map(employee,employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Transactional
    public EmployeeDTO getEmployeeByCredentials( String email, String password){

        Employee emplogit remote show origin yee = employeeRepository.getEmployeeByCredentials(email,password);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        modelMapper.map(employee,employeeDTO);
        return  employeeDTO;

    }


}
