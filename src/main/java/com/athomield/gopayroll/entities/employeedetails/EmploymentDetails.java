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

    @JsonManagedReference(value = "emp_det_emp_cat")
    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentCategory> employmentCategories;

    @JsonManagedReference(value = "emp_det_emp_pos")
    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentPosition> employmentPositions;

    @JsonManagedReference(value = "emp_det_coll_conv")
    @OneToMany(mappedBy = "employmentDetails")
    private List<CollectiveConvention> collectiveConventions;

    @JsonManagedReference(value = "emp_det_emp_qual")
    @OneToMany(mappedBy = "employmentDetails")
    private List<EmploymentQualification> employmentQualifications;

    @JsonManagedReference(value = "emp_det_dep")
    @OneToMany(mappedBy = "employmentDetails")
    private List<Department> departments;
}