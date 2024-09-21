package com.athomield.gopayroll.entities;

import com.athomield.gopayroll.entities.employee.EmployeeEmploymentDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private double salary;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company_id")
    private Company company;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_employment_details_id", referencedColumnName = "id")
    @JsonBackReference
    private EmployeeEmploymentDetails employeeEmploymentDetails;

    public Employee(String name, String email, double salary, Company company) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

}