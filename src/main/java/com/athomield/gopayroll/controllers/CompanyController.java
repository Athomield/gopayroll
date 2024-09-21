package com.athomield.gopayroll.controllers;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.entities.employeedetails.EmploymentDetails;
import com.athomield.gopayroll.services.CompanyService;
import com.athomield.gopayroll.services.employeedetails.EmploymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmploymentDetailsService employmentDetailsService;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company newCompany = company;
        EmploymentDetails employmentDetails = new EmploymentDetails();

        newCompany.setEmploymentDetails(employmentDetails);
        employmentDetailsService.saveEmploymentDetails(employmentDetails);

        Company savedCompany = companyService.saveCompany(newCompany);

        return ResponseEntity.ok(savedCompany);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        Company updatedCompany = companyService.updateCompany(id, companyDetails);
        if (updatedCompany != null) {
            return ResponseEntity.ok(updatedCompany);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}