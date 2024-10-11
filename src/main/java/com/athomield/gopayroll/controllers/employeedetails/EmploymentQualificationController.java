package com.athomield.gopayroll.controllers.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentQualification;
import com.athomield.gopayroll.services.employeedetails.EmploymentQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employment-qualifications")
public class EmploymentQualificationController {

    @Autowired
    private EmploymentQualificationService employmentQualificationService;

    // Create a new EmploymentQualification
    @PostMapping
    public ResponseEntity<EmploymentQualification> createEmploymentQualification(@RequestBody EmploymentQualification employmentQualification) {
        EmploymentQualification savedEmploymentQualification = employmentQualificationService.saveEmploymentQualification(employmentQualification);
        return ResponseEntity.ok(savedEmploymentQualification);
    }

    // Get an EmploymentQualification by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentQualification> getEmploymentQualificationById(@PathVariable Long id) {
        Optional<EmploymentQualification> employmentQualification = employmentQualificationService.getEmploymentQualificationById(id);
        return employmentQualification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all EmploymentQualifications
    @GetMapping
    public ResponseEntity<List<EmploymentQualification>> getAllEmploymentQualifications() {
        List<EmploymentQualification> employmentQualifications = employmentQualificationService.getAllEmploymentQualifications();
        return ResponseEntity.ok(employmentQualifications);
    }

    // Update an existing EmploymentQualification
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentQualification> updateEmploymentQualification(
            @PathVariable Long id,
            @RequestBody EmploymentQualification employmentQualificationDetails) {

        EmploymentQualification updatedEmploymentQualification = employmentQualificationService.updateEmploymentQualification(id, employmentQualificationDetails);
        if (updatedEmploymentQualification != null) {
            return ResponseEntity.ok(updatedEmploymentQualification);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an EmploymentQualification by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploymentQualification(@PathVariable Long id) {
        employmentQualificationService.deleteEmploymentQualification(id);
        return ResponseEntity.noContent().build();
    }
}
