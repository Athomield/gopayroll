package com.athomield.gopayroll.services.employee;

import com.athomield.gopayroll.entities.employee.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryService {

    Salary saveOrUpdateSalary(Salary salary);

    List<Salary> getAllSalaries();

    Optional<Salary> getSalaryById(Long id);

    void deleteSalaryById(Long id);
}
