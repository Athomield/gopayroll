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
public class CollectiveConvention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String description;

    @JsonBackReference(value = "emp_det_coll_conv")
    @ManyToOne
    @JoinColumn(name="employment_details_id")
    private EmploymentDetails employmentDetails;

}