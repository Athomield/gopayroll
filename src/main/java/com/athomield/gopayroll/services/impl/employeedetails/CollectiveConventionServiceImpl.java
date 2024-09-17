package com.athomield.gopayroll.services.impl.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.CollectiveConvention;
import com.athomield.gopayroll.repositories.employeedetails.CollectiveConventionRepository;
import com.athomield.gopayroll.services.employeedetails.CollectiveConventionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectiveConventionServiceImpl implements CollectiveConventionService {

    private final CollectiveConventionRepository collectiveConventionRepository;

    public CollectiveConventionServiceImpl(CollectiveConventionRepository collectiveConventionRepository) {
        this.collectiveConventionRepository = collectiveConventionRepository;
    }

    @Override
    public CollectiveConvention saveCollectiveConvention(CollectiveConvention collectiveConvention) {
        return collectiveConventionRepository.save(collectiveConvention);
    }

    @Override
    public Optional<CollectiveConvention> getCollectiveConventionById(Long id) {
        return collectiveConventionRepository.findById(id);
    }

    @Override
    public List<CollectiveConvention> getAllCollectiveConventions() {
        return collectiveConventionRepository.findAll();
    }

    @Override
    public CollectiveConvention updateCollectiveConvention(Long id, CollectiveConvention collectiveConvention) {
        Optional<CollectiveConvention> existing = collectiveConventionRepository.findById(id);
        if (existing.isPresent()) {
            CollectiveConvention updatedConvention = existing.get();
            updatedConvention.setCode(collectiveConvention.getCode());
            updatedConvention.setDescription(collectiveConvention.getDescription());
            updatedConvention.setEmploymentDetails(collectiveConvention.getEmploymentDetails());
            return collectiveConventionRepository.save(updatedConvention);
        }
        return null;
    }

    @Override
    public void deleteCollectiveConvention(Long id) {
        collectiveConventionRepository.deleteById(id);
    }
}