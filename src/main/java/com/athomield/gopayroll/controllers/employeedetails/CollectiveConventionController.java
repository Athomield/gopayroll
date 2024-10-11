package com.athomield.gopayroll.controllers.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.CollectiveConvention;
import com.athomield.gopayroll.services.employeedetails.CollectiveConventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/collective-conventions")
public class CollectiveConventionController {

    @Autowired
    private CollectiveConventionService collectiveConventionService;


    // Create a new CollectiveConvention
    @PostMapping
    public ResponseEntity<CollectiveConvention> createCollectiveConvention(@RequestBody CollectiveConvention collectiveConvention) {
        CollectiveConvention savedCollectiveConvention = collectiveConventionService.saveCollectiveConvention(collectiveConvention);
        return ResponseEntity.ok(savedCollectiveConvention);
    }

    // Get a CollectiveConvention by ID
    @GetMapping("/{id}")
    public ResponseEntity<CollectiveConvention> getCollectiveConventionById(@PathVariable Long id) {
        Optional<CollectiveConvention> collectiveConvention = collectiveConventionService.getCollectiveConventionById(id);
        return collectiveConvention.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all CollectiveConventions
    @GetMapping
    public ResponseEntity<List<CollectiveConvention>> getAllCollectiveConventions() {
        List<CollectiveConvention> collectiveConventions = collectiveConventionService.getAllCollectiveConventions();
        return ResponseEntity.ok(collectiveConventions);
    }

    // Update an existing CollectiveConvention
    @PutMapping("/{id}")
    public ResponseEntity<CollectiveConvention> updateCollectiveConvention(
            @PathVariable Long id,
            @RequestBody CollectiveConvention collectiveConventionDetails) {

        CollectiveConvention updatedCollectiveConvention = collectiveConventionService.updateCollectiveConvention(id, collectiveConventionDetails);
        if (updatedCollectiveConvention != null) {
            return ResponseEntity.ok(updatedCollectiveConvention);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a CollectiveConvention by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollectiveConvention(@PathVariable Long id) {
        collectiveConventionService.deleteCollectiveConvention(id);
        return ResponseEntity.noContent().build();
    }
}
