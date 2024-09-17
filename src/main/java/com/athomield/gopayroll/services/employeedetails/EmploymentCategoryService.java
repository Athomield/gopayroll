package com.athomield.gopayroll.services.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentCategory;
import java.util.List;
import java.util.Optional;

public interface EmploymentCategoryService {

    // Create or save an EmploymentCategory
    EmploymentCategory saveEmploymentCategory(EmploymentCategory employmentCategory);

    // Get an EmploymentCategory by ID
    Optional<EmploymentCategory> getEmploymentCategoryById(Long id);

    // Get all EmploymentCategories
    List<EmploymentCategory> getAllEmploymentCategories();

    // Update an EmploymentCategory
    EmploymentCategory updateEmploymentCategory(Long id, EmploymentCategory employmentCategory);

    // Delete an EmploymentCategory
    void deleteEmploymentCategory(Long id);
}