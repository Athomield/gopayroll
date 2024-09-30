package com.athomield.gopayroll.controllers.employee;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.entities.Country;
import com.athomield.gopayroll.entities.dto.CivilityRequestBody;
import com.athomield.gopayroll.entities.employee.Civility;
import com.athomield.gopayroll.services.CompanyService;
import com.athomield.gopayroll.services.employee.CivilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/civilities")
public class CivilityController {

    @Autowired
    private CivilityService civilityService;

    @Autowired
    private CompanyService companyService;

    // Create a new Civility
    @PostMapping
    public ResponseEntity<Civility> createCivility(@RequestBody CivilityRequestBody countryRequestBody) {

        Civility newCivility = new Civility();
        newCivility.setCode(countryRequestBody.getCode());
        newCivility.setName(countryRequestBody.getName());

        Company company = companyService.getCompanyById(countryRequestBody.getCompany_id());
        newCivility.setCompany(company);
        Civility savedCivility = civilityService.saveCivility(newCivility);

        return ResponseEntity.ok(savedCivility);
    }

    // Get a Civility by ID
    @GetMapping("/{id}")
    public ResponseEntity<Civility> getCivilityById(@PathVariable Long id) {
        Optional<Civility> civility = civilityService.getCivilityById(id);
        return civility.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Countries
    @GetMapping
    public ResponseEntity<List<Civility>> getAllCivilities() {
        List<Civility> civilities = civilityService.getAllCivilities();
        return ResponseEntity.ok(civilities);
    }

    // Update an existing Civility
    @PutMapping("/{id}")
    public ResponseEntity<Civility> updateCivility(@PathVariable Long id, @RequestBody Civility civilityDetails) {
        Civility updatedCivility = civilityService.updateCivility(id, civilityDetails);
        if (updatedCivility != null) {
            return ResponseEntity.ok(updatedCivility);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Civility by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCivility(@PathVariable Long id) {
        civilityService.deleteCivility(id);
        return ResponseEntity.noContent().build();
    }
}
