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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String description;

    @ManyToOne
    @JsonBackReference(value = "emp_det_dep")
    @JoinColumn(name="employment_details_id")
    private EmploymentDetails employmentDetails;

    public Department(String code, String description) {
        this.code = code;
        this.description = description;
    }
}