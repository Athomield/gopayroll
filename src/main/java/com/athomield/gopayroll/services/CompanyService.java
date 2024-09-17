package com.athomield.gopayroll.services;

import com.athomield.gopayroll.entities.Company;
import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    Company getCompanyById(Long id);

    List<Company> getAllCompanies();

    Company updateCompany(Long id, Company company);

    void deleteCompany(Long id);
}