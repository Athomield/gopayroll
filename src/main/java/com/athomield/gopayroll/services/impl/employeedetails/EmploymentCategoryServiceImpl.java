package com.athomield.gopayroll.services.impl.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentCategory;
import com.athomield.gopayroll.repositories.employeedetails.EmploymentCategoryRepository;
import com.athomield.gopayroll.services.employeedetails.EmploymentCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentCategoryServiceImpl implements EmploymentCategoryService {

    private final EmploymentCategoryRepository employmentCategoryRepository;

    public EmploymentCategoryServiceImpl(EmploymentCategoryRepository employmentCategoryRepository) {
        this.employmentCategoryRepository = employmentCategoryRepository;
    }

    @Override
    public EmploymentCategory saveEmploymentCategory(EmploymentCategory employmentCategory) {
        return employmentCategoryRepository.save(employmentCategory);
    }

    @Override
    public Optional<EmploymentCategory> getEmploymentCategoryById(Long id) {
        return employmentCategoryRepository.findById(id);
    }

    @Override
    public List<EmploymentCategory> getAllEmploymentCategories() {
        return employmentCategoryRepository.findAll();
    }

    @Override
    public EmploymentCategory updateEmploymentCategory(Long id, EmploymentCategory employmentCategory) {
        Optional<EmploymentCategory> existing = employmentCategoryRepository.findById(id);
        if (existing.isPresent()) {
            EmploymentCategory updatedCategory = existing.get();
            updatedCategory.setCode(employmentCategory.getCode());
            updatedCategory.setDescription(employmentCategory.getDescription());
            updatedCategory.setEmploymentDetails(employmentCategory.getEmploymentDetails());
            return employmentCategoryRepository.save(updatedCategory);
        }
        return null;
    }

    @Override
    public void deleteEmploymentCategory(Long id) {
        employmentCategoryRepository.deleteById(id);
    }
}