package com.athomield.gopayroll.services.impl;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.repositories.CompanyRepository;
import com.athomield.gopayroll.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Long id, Company companyDetails) {
        Optional<Company> existingCompany = companyRepository.findById(id);

        if (existingCompany.isPresent()) {
            Company company = existingCompany.get();
            company.setName(companyDetails.getName());
            company.setAddress(companyDetails.getAddress());
            return companyRepository.save(company);
        }

        return null;
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}