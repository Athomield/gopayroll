package com.athomield.gopayroll.services.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.Department;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    // Create or save a Department
    Department saveDepartment(Department department);

    // Get a Department by ID
    Optional<Department> getDepartmentById(Long id);

    // Get all Departments
    List<Department> getAllDepartments();

    // Update a Department
    Department updateDepartment(Long id, Department department);

    // Delete a Department
    void deleteDepartment(Long id);
}