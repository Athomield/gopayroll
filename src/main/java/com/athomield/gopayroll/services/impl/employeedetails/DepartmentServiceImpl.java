package com.athomield.gopayroll.services.impl.employeedetails;


import com.athomield.gopayroll.entities.employeedetails.Department;
import com.athomield.gopayroll.repositories.employeedetails.DepartmentRepository;
import com.athomield.gopayroll.services.employeedetails.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Optional<Department> existing = departmentRepository.findById(id);
        if (existing.isPresent()) {
            Department updatedDepartment = existing.get();
            updatedDepartment.setCode(department.getCode());
            updatedDepartment.setDescription(department.getDescription());
            updatedDepartment.setEmploymentDetails(department.getEmploymentDetails());
            return departmentRepository.save(updatedDepartment);
        }
        return null;
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}