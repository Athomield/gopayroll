package com.athomield.gopayroll.entities.employeedetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmploymentQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String description;

    @JsonBackReference(value = "emp_det_emp_qual")
    @ManyToOne
    @JoinColumn(name="employment_details_id")
    private EmploymentDetails employmentDetails;

    public EmploymentQualification(String code, String description) {
        this.code = code;
        this.description = description;
    }

}