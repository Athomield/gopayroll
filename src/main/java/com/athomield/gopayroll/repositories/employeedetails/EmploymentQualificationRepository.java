package com.athomield.gopayroll.repositories.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentQualificationRepository extends JpaRepository<EmploymentQualification, Long> {

}