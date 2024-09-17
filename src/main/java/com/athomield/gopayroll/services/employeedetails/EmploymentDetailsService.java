package com.athomield.gopayroll.services.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentDetails;
import java.util.List;
import java.util.Optional;

public interface EmploymentDetailsService {

    // Create or save EmploymentDetails
    EmploymentDetails saveEmploymentDetails(EmploymentDetails employmentDetails);

    // Get EmploymentDetails by ID
    Optional<EmploymentDetails> getEmploymentDetailsById(Long id);

    // Get all EmploymentDetails
    List<EmploymentDetails> getAllEmploymentDetails();

    // Update EmploymentDetails
    EmploymentDetails updateEmploymentDetails(Long id, EmploymentDetails employmentDetails);

    // Delete EmploymentDetails
    void deleteEmploymentDetails(Long id);
}