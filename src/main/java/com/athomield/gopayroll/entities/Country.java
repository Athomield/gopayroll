package com.athomield.gopayroll.entities;

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
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @ManyToOne
    @JsonBackReference(value = "countr_comp")
    @JoinColumn(name="company_id")
    private Company company;

}
