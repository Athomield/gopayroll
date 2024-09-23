package com.athomield.gopayroll.controllers.employeedetails;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.entities.employeedetails.Department;
import com.athomield.gopayroll.entities.requestbodies.DepartmentRequestBody;
import com.athomield.gopayroll.services.CompanyService;
import com.athomield.gopayroll.services.employeedetails.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;

    // Create a new Department
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentRequestBody departmentRequestBody) {
        Department department = new Department(departmentRequestBody.getCode(),departmentRequestBody.getDescription());
        Company company = companyService.getCompanyById(departmentRequestBody.getCompany_id());
        department.setEmploymentDetails(company.getEmploymentDetails());
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    // Get a Department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Departments
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Update an existing Department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable Long id,
            @RequestBody Department departmentDetails) {

        Department updatedDepartment = departmentService.updateDepartment(id, departmentDetails);
        if (updatedDepartment != null) {
            return ResponseEntity.ok(updatedDepartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Department by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}