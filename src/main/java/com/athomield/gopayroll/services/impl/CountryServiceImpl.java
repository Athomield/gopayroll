package com.athomield.gopayroll.services.impl;

import com.athomield.gopayroll.entities.Country;
import com.athomield.gopayroll.repositories.CountryRepository;
import com.athomield.gopayroll.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country updateCountry(Long id, Country countryDetails) {
        return countryRepository.findById(id)
                .map(country -> {
                    country.setCode(countryDetails.getCode());
                    country.setName(countryDetails.getName());
                    country.setCompany(countryDetails.getCompany());
                    return countryRepository.save(country);
                }).orElse(null);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
