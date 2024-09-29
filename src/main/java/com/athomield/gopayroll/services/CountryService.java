package com.athomield.gopayroll.services;

import com.athomield.gopayroll.entities.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country saveCountry(Country country);

    Optional<Country> getCountryById(Long id);

    List<Country> getAllCountries();

    Country updateCountry(Long id, Country countryDetails);

    void deleteCountry(Long id);
}
