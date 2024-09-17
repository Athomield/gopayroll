package com.athomield.gopayroll.repositories.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.athomield.gopayroll.entities.employee.EmployeeEmploymentDetails;

@Repository
public interface EmployeeEmploymentDetailsRepository extends JpaRepository<EmployeeEmploymentDetails, Long> {

}