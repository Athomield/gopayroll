package com.athomield.gopayroll.services.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.CollectiveConvention;
import java.util.List;
import java.util.Optional;

public interface CollectiveConventionService {

    // Create or save a CollectiveConvention
    CollectiveConvention saveCollectiveConvention(CollectiveConvention collectiveConvention);

    // Get a CollectiveConvention by ID
    Optional<CollectiveConvention> getCollectiveConventionById(Long id);

    // Get all CollectiveConventions
    List<CollectiveConvention> getAllCollectiveConventions();

    // Update a CollectiveConvention
    CollectiveConvention updateCollectiveConvention(Long id, CollectiveConvention collectiveConvention);

    // Delete a CollectiveConvention
    void deleteCollectiveConvention(Long id);
}