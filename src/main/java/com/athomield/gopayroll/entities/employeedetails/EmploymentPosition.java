package com.athomield.gopayroll.entities.employeedetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmploymentPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String description;

    @ManyToOne
    @JoinColumn(name="employment_details_id")
    private EmploymentDetails employmentDetails;

    public EmploymentPosition(String code, String description) {
        this.code = code;
        this.description = description;
    }


}