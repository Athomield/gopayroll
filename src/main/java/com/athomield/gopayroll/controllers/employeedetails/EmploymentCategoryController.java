package com.athomield.gopayroll.controllers.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.EmploymentCategory;
import com.athomield.gopayroll.services.employeedetails.EmploymentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employment-categories")
public class EmploymentCategoryController {

    @Autowired
    private EmploymentCategoryService employmentCategoryService;

    // Create a new EmploymentCategory
    @PostMapping
    public ResponseEntity<EmploymentCategory> createEmploymentCategory(@RequestBody EmploymentCategory employmentCategory) {
        EmploymentCategory savedEmploymentCategory = employmentCategoryService.saveEmploymentCategory(employmentCategory);
        return ResponseEntity.ok(savedEmploymentCategory);
    }

    // Get an EmploymentCategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentCategory> getEmploymentCategoryById(@PathVariable Long id) {
        Optional<EmploymentCategory> employmentCategory = employmentCategoryService.getEmploymentCategoryById(id);
        return employmentCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all EmploymentCategories
    @GetMapping
    public ResponseEntity<List<EmploymentCategory>> getAllEmploymentCategories() {
        List<EmploymentCategory> employmentCategories = employmentCategoryService.getAllEmploymentCategories();
        return ResponseEntity.ok(employmentCategories);
    }

    // Update an existing EmploymentCategory
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentCategory> updateEmploymentCategory(
            @PathVariable Long id,
            @RequestBody EmploymentCategory employmentCategoryDetails) {

        EmploymentCategory updatedEmploymentCategory = employmentCategoryService.updateEmploymentCategory(id, employmentCategoryDetails);
        if (updatedEmploymentCategory != null) {
            return ResponseEntity.ok(updatedEmploymentCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an EmploymentCategory by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploymentCategory(@PathVariable Long id) {
        employmentCategoryService.deleteEmploymentCategory(id);
        return ResponseEntity.noContent().build();
    }
}
