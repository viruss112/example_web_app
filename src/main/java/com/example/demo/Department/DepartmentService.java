package com.example.demo.Department;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {


    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(ModelMapper modelMapper, DepartmentRepository departmentRepository) {
        this.modelMapper = modelMapper;
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDTO create(DepartmentDTO departmentDTO) {

        Department department = new Department();
        modelMapper.map(departmentDTO, department);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDTO departmentDTO1 = new DepartmentDTO();
        modelMapper.map(savedDepartment, departmentDTO1);
        return departmentDTO1;

    }

    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departmentList = new ArrayList<>();
        departmentList = (List<Department>) departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department department : departmentList) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            modelMapper.map(department, departmentDTO);
            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }

    @Transactional
    public DepartmentDTO popularDepartment() {
        List<Department> departmentList = departmentRepository.popularDepartment();
        Department bestDepartment = departmentList.get(0);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        modelMapper.map(bestDepartment, departmentDTO);
        departmentDTO.setDepartmentId(null);
        departmentDTO.setEmployeeId(null);
        return departmentDTO;
    }
}
