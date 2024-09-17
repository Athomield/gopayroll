package com.athomield.gopayroll.repositories.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmploymentDetailsRepository extends JpaRepository<EmploymentDetails, Long> {

}