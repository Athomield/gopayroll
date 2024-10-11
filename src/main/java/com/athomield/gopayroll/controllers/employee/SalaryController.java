package com.athomield.gopayroll.controllers.employee;

import com.athomield.gopayroll.entities.employee.Salary;
import com.athomield.gopayroll.services.employee.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    // Get all salaries
    @GetMapping
    public ResponseEntity<List<Salary>> getAllSalaries() {
        List<Salary> salaries = salaryService.getAllSalaries();
        return ResponseEntity.ok(salaries);
    }

    // Get a salary by ID
    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
        Optional<Salary> salary = salaryService.getSalaryById(id);
        return salary.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new salary
    @PostMapping
    public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
        Salary newSalary = salaryService.saveOrUpdateSalary(salary);
        return ResponseEntity.ok(newSalary);
    }

    // Update an existing salary
    @PutMapping("/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @RequestBody Salary updatedSalary) {
        Optional<Salary> existingSalary = salaryService.getSalaryById(id);
        if (existingSalary.isPresent()) {
            updatedSalary.setId(id); // Ensure the ID remains the same
            Salary savedSalary = salaryService.saveOrUpdateSalary(updatedSalary);
            return ResponseEntity.ok(savedSalary);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a salary by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalaryById(@PathVariable Long id) {
        Optional<Salary> existingSalary = salaryService.getSalaryById(id);
        if (existingSalary.isPresent()) {
            salaryService.deleteSalaryById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
