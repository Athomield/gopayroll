package com.athomield.gopayroll.services.employeedetails;
import com.athomield.gopayroll.entities.employeedetails.EmploymentPosition;
import java.util.List;
import java.util.Optional;

public interface EmploymentPositionService {

    // Create or save an EmploymentPosition
    EmploymentPosition saveEmploymentPosition(EmploymentPosition employmentPosition);

    // Get an EmploymentPosition by ID
    Optional<EmploymentPosition> getEmploymentPositionById(Long id);

    // Get all EmploymentPositions
    List<EmploymentPosition> getAllEmploymentPositions();

    // Update an EmploymentPosition
    EmploymentPosition updateEmploymentPosition(Long id, EmploymentPosition employmentPosition);

    // Delete an EmploymentPosition
    void deleteEmploymentPosition(Long id);
}