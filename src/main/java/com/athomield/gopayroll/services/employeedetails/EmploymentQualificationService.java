package com.athomield.gopayroll.services.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentQualification;
import java.util.List;
import java.util.Optional;

public interface EmploymentQualificationService {

    // Create or save an EmploymentQualification
    EmploymentQualification saveEmploymentQualification(EmploymentQualification employmentQualification);

    // Get an EmploymentQualification by ID
    Optional<EmploymentQualification> getEmploymentQualificationById(Long id);

    // Get all EmploymentQualifications
    List<EmploymentQualification> getAllEmploymentQualifications();

    // Update an EmploymentQualification
    EmploymentQualification updateEmploymentQualification(Long id, EmploymentQualification employmentQualification);

    // Delete an EmploymentQualification
    void deleteEmploymentQualification(Long id);
}