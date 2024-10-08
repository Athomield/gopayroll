package com.athomield.gopayroll.controllers;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.entities.Country;
import com.athomield.gopayroll.entities.dto.CountryRequestBody;
import com.athomield.gopayroll.services.CompanyService;
import com.athomield.gopayroll.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CompanyService companyService;

    // Create a new Country
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody CountryRequestBody countryRequestBody) {
        Country newCountry = new Country();
        newCountry.setCode(countryRequestBody.getCode());
        newCountry.setName(countryRequestBody.getName());

        Company company = companyService.getCompanyById(countryRequestBody.getCompany_id());
        newCountry.setCompany(company);
        Country savedCountry = countryService.saveCountry(newCountry);

        return ResponseEntity.ok(savedCountry);
    }

    // Get a Country by ID
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Optional<Country> country = countryService.getCountryById(id);
        return country.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Countries
    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    // Update an existing Country
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country countryDetails) {
        Country updatedCountry = countryService.updateCountry(id, countryDetails);
        if (updatedCountry != null) {
            return ResponseEntity.ok(updatedCountry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Country by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
