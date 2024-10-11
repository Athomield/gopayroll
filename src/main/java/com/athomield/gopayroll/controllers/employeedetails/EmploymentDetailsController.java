package com.athomield.gopayroll.controllers.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentDetails;
import com.athomield.gopayroll.services.employeedetails.EmploymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employment-details")
public class EmploymentDetailsController {

    @Autowired
    private EmploymentDetailsService employmentDetailsService;

    // Create new EmploymentDetails
    @PostMapping
    public ResponseEntity<EmploymentDetails> createEmploymentDetails(@RequestBody EmploymentDetails employmentDetails) {
        EmploymentDetails savedDetails = employmentDetailsService.saveEmploymentDetails(employmentDetails);
        return ResponseEntity.ok(savedDetails);
    }

    // Get EmploymentDetails by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentDetails> getEmploymentDetailsById(@PathVariable Long id) {
        Optional<EmploymentDetails> employmentDetails = employmentDetailsService.getEmploymentDetailsById(id);
        return employmentDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all EmploymentDetails
    @GetMapping
    public ResponseEntity<List<EmploymentDetails>> getAllEmploymentDetails() {
        List<EmploymentDetails> detailsList = employmentDetailsService.getAllEmploymentDetails();
        return ResponseEntity.ok(detailsList);
    }

    // Update EmploymentDetails by ID
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentDetails> updateEmploymentDetails(
            @PathVariable Long id, @RequestBody EmploymentDetails employmentDetailsDetails) {
        EmploymentDetails updatedDetails = employmentDetailsService.updateEmploymentDetails(id, employmentDetailsDetails);
        if (updatedDetails != null) {
            return ResponseEntity.ok(updatedDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete EmploymentDetails by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploymentDetails(@PathVariable Long id) {
        employmentDetailsService.deleteEmploymentDetails(id);
        return ResponseEntity.noContent().build();
    }
}
