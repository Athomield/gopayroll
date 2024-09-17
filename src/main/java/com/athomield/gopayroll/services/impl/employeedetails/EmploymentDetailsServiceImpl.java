package com.athomield.gopayroll.services.impl.employeedetails;
import com.athomield.gopayroll.entities.employeedetails.EmploymentDetails;
import com.athomield.gopayroll.repositories.employeedetails.EmploymentDetailsRepository;
import com.athomield.gopayroll.services.employeedetails.EmploymentDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentDetailsServiceImpl implements EmploymentDetailsService {

    private final EmploymentDetailsRepository employmentDetailsRepository;

    public EmploymentDetailsServiceImpl(EmploymentDetailsRepository employmentDetailsRepository) {
        this.employmentDetailsRepository = employmentDetailsRepository;
    }

    @Override
    public EmploymentDetails saveEmploymentDetails(EmploymentDetails employmentDetails) {
        return employmentDetailsRepository.save(employmentDetails);
    }

    @Override
    public Optional<EmploymentDetails> getEmploymentDetailsById(Long id) {
        return employmentDetailsRepository.findById(id);
    }

    @Override
    public List<EmploymentDetails> getAllEmploymentDetails() {
        return employmentDetailsRepository.findAll();
    }

    @Override
    public EmploymentDetails updateEmploymentDetails(Long id, EmploymentDetails employmentDetails) {
        Optional<EmploymentDetails> existing = employmentDetailsRepository.findById(id);
        if (existing.isPresent()) {
            EmploymentDetails updatedDetails = existing.get();
            updatedDetails.setCompany(employmentDetails.getCompany());
            updatedDetails.setEmploymentCategories(employmentDetails.getEmploymentCategories());
            updatedDetails.setEmploymentPositions(employmentDetails.getEmploymentPositions());
            updatedDetails.setCollectiveConventions(employmentDetails.getCollectiveConventions());
            updatedDetails.setEmploymentQualifications(employmentDetails.getEmploymentQualifications());
            updatedDetails.setDepartments(employmentDetails.getDepartments());
            return employmentDetailsRepository.save(updatedDetails);
        }
        return null;
    }

    @Override
    public void deleteEmploymentDetails(Long id) {
        employmentDetailsRepository.deleteById(id);
    }
}