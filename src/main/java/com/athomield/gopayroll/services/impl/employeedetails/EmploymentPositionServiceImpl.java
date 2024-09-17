package com.athomield.gopayroll.services.impl.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentPosition;
import com.athomield.gopayroll.repositories.employeedetails.EmploymentPositionRepository;
import com.athomield.gopayroll.services.employeedetails.EmploymentPositionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentPositionServiceImpl implements EmploymentPositionService {

    private final EmploymentPositionRepository employmentPositionRepository;

    public EmploymentPositionServiceImpl(EmploymentPositionRepository employmentPositionRepository) {
        this.employmentPositionRepository = employmentPositionRepository;
    }

    @Override
    public EmploymentPosition saveEmploymentPosition(EmploymentPosition employmentPosition) {
        return employmentPositionRepository.save(employmentPosition);
    }

    @Override
    public Optional<EmploymentPosition> getEmploymentPositionById(Long id) {
        return employmentPositionRepository.findById(id);
    }

    @Override
    public List<EmploymentPosition> getAllEmploymentPositions() {
        return employmentPositionRepository.findAll();
    }

    @Override
    public EmploymentPosition updateEmploymentPosition(Long id, EmploymentPosition employmentPosition) {
        Optional<EmploymentPosition> existing = employmentPositionRepository.findById(id);
        if (existing.isPresent()) {
            EmploymentPosition updatedPosition = existing.get();
            updatedPosition.setCode(employmentPosition.getCode());
            updatedPosition.setDescription(employmentPosition.getDescription());
            updatedPosition.setEmploymentDetails(employmentPosition.getEmploymentDetails());
            return employmentPositionRepository.save(updatedPosition);
        }
        return null;
    }

    @Override
    public void deleteEmploymentPosition(Long id) {
        employmentPositionRepository.deleteById(id);
    }
}