package com.athomield.gopayroll.controllers.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentPosition;
import com.athomield.gopayroll.services.employeedetails.EmploymentPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employment-positions")
public class EmploymentPositionController {

    @Autowired
    private EmploymentPositionService employmentPositionService;

    // Create a new EmploymentPosition
    @PostMapping
    public ResponseEntity<EmploymentPosition> createEmploymentPosition(@RequestBody EmploymentPosition employmentPosition) {
        EmploymentPosition savedEmploymentPosition = employmentPositionService.saveEmploymentPosition(employmentPosition);
        return ResponseEntity.ok(savedEmploymentPosition);
    }

    // Get an EmploymentPosition by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentPosition> getEmploymentPositionById(@PathVariable Long id) {
        Optional<EmploymentPosition> employmentPosition = employmentPositionService.getEmploymentPositionById(id);
        return employmentPosition.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all EmploymentPositions
    @GetMapping
    public ResponseEntity<List<EmploymentPosition>> getAllEmploymentPositions() {
        List<EmploymentPosition> employmentPositions = employmentPositionService.getAllEmploymentPositions();
        return ResponseEntity.ok(employmentPositions);
    }

    // Update an existing EmploymentPosition
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentPosition> updateEmploymentPosition(
            @PathVariable Long id,
            @RequestBody EmploymentPosition employmentPositionDetails) {

        EmploymentPosition updatedEmploymentPosition = employmentPositionService.updateEmploymentPosition(id, employmentPositionDetails);
        if (updatedEmploymentPosition != null) {
            return ResponseEntity.ok(updatedEmploymentPosition);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an EmploymentPosition by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploymentPosition(@PathVariable Long id) {
        employmentPositionService.deleteEmploymentPosition(id);
        return ResponseEntity.noContent().build();
    }
}
