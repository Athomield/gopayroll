package com.athomield.gopayroll.entities.employeedetails;

import com.athomield.gopayroll.entities.Company;
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

    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentCategory> employmentCategories;

    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentPosition> employmentPositions;

    @OneToMany(mappedBy = "employmentDetails")
    private List<CollectiveConvention> collectiveConventions;

    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentQualification> employmentQualifications;

    @OneToMany(mappedBy = "employmentDetails")
    private List<Department> departments;
}