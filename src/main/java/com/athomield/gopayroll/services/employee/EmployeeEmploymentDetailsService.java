package com.athomield.gopayroll.services.employee;

import com.athomield.gopayroll.entities.employee.EmployeeEmploymentDetails;
import java.util.List;
import java.util.Optional;

public interface EmployeeEmploymentDetailsService {

    // Create or save EmployeeEmploymentDetails
    EmployeeEmploymentDetails saveEmployeeEmploymentDetails(EmployeeEmploymentDetails employeeEmploymentDetails);

    // Get EmployeeEmploymentDetails by ID
    Optional<EmployeeEmploymentDetails> getEmployeeEmploymentDetailsById(Long id);

    // Get all EmployeeEmploymentDetails
    List<EmployeeEmploymentDetails> getAllEmployeeEmploymentDetails();

    // Update EmployeeEmploymentDetails
    EmployeeEmploymentDetails updateEmployeeEmploymentDetails(Long id, EmployeeEmploymentDetails employeeEmploymentDetails);

    // Delete EmployeeEmploymentDetails
    void deleteEmployeeEmploymentDetails(Long id);
}