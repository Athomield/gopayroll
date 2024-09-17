package com.athomield.gopayroll.services.impl.employee;
import com.athomield.gopayroll.entities.employee.EmployeeEmploymentDetails;
import com.athomield.gopayroll.repositories.employee.EmployeeEmploymentDetailsRepository;
import com.athomield.gopayroll.services.employee.EmployeeEmploymentDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeEmploymentDetailsServiceImpl implements EmployeeEmploymentDetailsService {

    private final EmployeeEmploymentDetailsRepository employeeEmploymentDetailsRepository;

    public EmployeeEmploymentDetailsServiceImpl(EmployeeEmploymentDetailsRepository employeeEmploymentDetailsRepository) {
        this.employeeEmploymentDetailsRepository = employeeEmploymentDetailsRepository;
    }

    @Override
    public EmployeeEmploymentDetails saveEmployeeEmploymentDetails(EmployeeEmploymentDetails employeeEmploymentDetails) {
        return employeeEmploymentDetailsRepository.save(employeeEmploymentDetails);
    }

    @Override
    public Optional<EmployeeEmploymentDetails> getEmployeeEmploymentDetailsById(Long id) {
        return employeeEmploymentDetailsRepository.findById(id);
    }

    @Override
    public List<EmployeeEmploymentDetails> getAllEmployeeEmploymentDetails() {
        return employeeEmploymentDetailsRepository.findAll();
    }

    @Override
    public EmployeeEmploymentDetails updateEmployeeEmploymentDetails(Long id, EmployeeEmploymentDetails employeeEmploymentDetails) {
        Optional<EmployeeEmploymentDetails> existing = employeeEmploymentDetailsRepository.findById(id);
        if (existing.isPresent()) {
            EmployeeEmploymentDetails updatedDetails = existing.get();
            updatedDetails.setEmployee(employeeEmploymentDetails.getEmployee());
            updatedDetails.setEmploymentCategoryId(employeeEmploymentDetails.getEmploymentCategoryId());
            updatedDetails.setEmploymentPositionsId(employeeEmploymentDetails.getEmploymentPositionsId());
            updatedDetails.setCollectiveConventionsId(employeeEmploymentDetails.getCollectiveConventionsId());
            updatedDetails.setEmploymentQualificationsId(employeeEmploymentDetails.getEmploymentQualificationsId());
            updatedDetails.setDepartmentId(employeeEmploymentDetails.getDepartmentId());
            return employeeEmploymentDetailsRepository.save(updatedDetails);
        }
        return null;
    }

    @Override
    public void deleteEmployeeEmploymentDetails(Long id) {
        employeeEmploymentDetailsRepository.deleteById(id);
    }
}