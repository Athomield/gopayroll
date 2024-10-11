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

    private String label;

    private String description;

    String monday_hours;
    String tuesday_hours;
    String wednesday_hours;
    String thursday_hours;
    String friday_hours;
    String saturday_hours;
    String sunday_hours;

    @ManyToOne
    @JsonBackReference(value = "emp_det_coll_con")
    @JoinColumn(name="employment_details_id")
    private EmploymentDetails employment_details;

}