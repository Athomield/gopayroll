package com.athomield.gopayroll.entities.employeedetails;

import com.athomield.gopayroll.entities.Company;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmploymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "employmentDetails")
    private Company company;

    @JsonManagedReference
    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentCategory> employmentCategories;

    @JsonManagedReference
    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentPosition> employmentPositions;

    @JsonManagedReference
    @OneToMany(mappedBy = "employmentDetails")
    private List<CollectiveConvention> collectiveConventions;

    @JsonManagedReference
    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentQualification> employmentQualifications;

    @JsonManagedReference
    @OneToMany(mappedBy = "employmentDetails")
    private List<Department> departments;
}