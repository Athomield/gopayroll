package com.athomield.gopayroll.repositories.employeedetails;

import com.athomield.gopayroll.entities.employeedetails.CollectiveConvention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CollectiveConventionRepository extends JpaRepository<CollectiveConvention, Long> {

}