package com.athomield.gopayroll.services.impl.employee;

import com.athomield.gopayroll.entities.employee.Civility;
import com.athomield.gopayroll.repositories.employee.CivilityRepository;
import com.athomield.gopayroll.services.employee.CivilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CivilityServiceImpl implements CivilityService {

    private final CivilityRepository civilityRepository;

    @Autowired
    public CivilityServiceImpl(CivilityRepository civilityRepository) {
        this.civilityRepository = civilityRepository;
    }

    @Override
    public Civility saveCivility(Civility civility) {
        return civilityRepository.save(civility);
    }

    @Override
    public Optional<Civility> getCivilityById(Long id) {
        return civilityRepository.findById(id);
    }

    @Override
    public List<Civility> getAllCivilities() {
        return civilityRepository.findAll();
    }

    @Override
    public Civility updateCivility(Long id, Civility civilityDetails) {
        return civilityRepository.findById(id)
                .map(civility -> {
                    civility.setCode(civilityDetails.getCode());
                    civility.setName(civilityDetails.getName());
                    civility.setCompany(civilityDetails.getCompany());
                    return civilityRepository.save(civility);
                }).orElse(null);
    }

    @Override
    public void deleteCivility(Long id) {
        civilityRepository.deleteById(id);
    }
}
