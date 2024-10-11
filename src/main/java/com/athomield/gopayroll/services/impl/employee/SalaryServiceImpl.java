package com.athomield.gopayroll.services.impl.employee;

import com.athomield.gopayroll.entities.employee.Salary;
import com.athomield.gopayroll.repositories.employee.SalaryRepository;
import com.athomield.gopayroll.services.employee.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Salary saveOrUpdateSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    @Override
    public Optional<Salary> getSalaryById(Long id) {
        return salaryRepository.findById(id);
    }

    @Override
    public void deleteSalaryById(Long id) {
        salaryRepository.deleteById(id);
    }
}
