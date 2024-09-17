package com.athomield.gopayroll.repositories.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentPositionRepository extends JpaRepository<EmploymentPosition, Long> {

}