package com.athomield.gopayroll.repositories.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.Department;
import com.athomield.gopayroll.entities.employeedetails.EmploymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentCategoryRepository extends JpaRepository<EmploymentCategory, Long> {

}