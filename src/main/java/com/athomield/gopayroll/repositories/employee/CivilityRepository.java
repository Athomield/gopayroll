package com.athomield.gopayroll.repositories.employee;

import com.athomield.gopayroll.entities.employee.Civility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivilityRepository extends JpaRepository<Civility, Long> {
    // Additional custom query methods (if needed) can be added here
}
