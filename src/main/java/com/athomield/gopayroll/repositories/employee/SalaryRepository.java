package com.athomield.gopayroll.repositories.employee;

import com.athomield.gopayroll.entities.employee.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    // You can define custom queries here if needed
}
