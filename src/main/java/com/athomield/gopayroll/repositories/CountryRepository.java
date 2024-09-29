package com.athomield.gopayroll.repositories;

import com.athomield.gopayroll.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    // Additional custom query methods (if needed) can be added here
}
