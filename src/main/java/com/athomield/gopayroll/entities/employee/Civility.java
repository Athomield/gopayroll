package com.athomield.gopayroll.entities.employee;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.entities.employeedetails.EmploymentDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Civility
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @ManyToOne
    @JsonBackReference(value = "civ_comp")
    @JoinColumn(name="company_id")
    private Company company;

}
