package com.athomield.gopayroll.services.impl.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentQualification;
import com.athomield.gopayroll.repositories.employeedetails.EmploymentQualificationRepository;
import com.athomield.gopayroll.services.employeedetails.EmploymentQualificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentQualificationServiceImpl implements EmploymentQualificationService {

    private final EmploymentQualificationRepository employmentQualificationRepository;

    public EmploymentQualificationServiceImpl(EmploymentQualificationRepository employmentQualificationRepository) {
        this.employmentQualificationRepository = employmentQualificationRepository;
    }

    @Override
    public EmploymentQualification saveEmploymentQualification(EmploymentQualification employmentQualification) {
        return employmentQualificationRepository.save(employmentQualification);
    }

    @Override
    public Optional<EmploymentQualification> getEmploymentQualificationById(Long id) {
        return employmentQualificationRepository.findById(id);
    }

    @Override
    public List<EmploymentQualification> getAllEmploymentQualifications() {
        return employmentQualificationRepository.findAll();
    }

    @Override
    public EmploymentQualification updateEmploymentQualification(Long id, EmploymentQualification employmentQualification) {
        Optional<EmploymentQualification> existing = employmentQualificationRepository.findById(id);
        if (existing.isPresent()) {
            EmploymentQualification updatedQualification = existing.get();
            updatedQualification.setCode(employmentQualification.getCode());
            updatedQualification.setDescription(employmentQualification.getDescription());
            updatedQualification.setEmploymentDetails(employmentQualification.getEmploymentDetails());
            return employmentQualificationRepository.save(updatedQualification);
        }
        return null;
    }

    @Override
    public void deleteEmploymentQualification(Long id) {
        employmentQualificationRepository.deleteById(id);
    }
}