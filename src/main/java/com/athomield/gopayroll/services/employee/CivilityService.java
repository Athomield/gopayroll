package com.athomield.gopayroll.services.employee;

import com.athomield.gopayroll.entities.employee.Civility;

import java.util.List;
import java.util.Optional;

public interface CivilityService {
    Civility saveCivility(Civility civility);

    Optional<Civility> getCivilityById(Long id);

    List<Civility> getAllCivilities();

    Civility updateCivility(Long id, Civility civilityDetails);

    void deleteCivility(Long id);
}
