package com.athomield.gopayroll.entities;

import com.athomield.gopayroll.entities.employee.Civility;
import com.athomield.gopayroll.entities.employee.EmployeeEmploymentDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "civility_id", referencedColumnName = "id")
    @JsonBackReference(value = "emp_civ")
    Civility civility;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthday_date;

    private String birthplace;

    private String ss_nbr;
    private String cpam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "birth_country_id", referencedColumnName = "id")
    @JsonBackReference(value = "emp_birth_countr")
    Country birth_country;

    private String name;

    private String last_name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonBackReference(value = "emp_addr")
    Address address;

    @ManyToOne
    @JsonBackReference(value = "emp_comp")
    @JoinColumn(name = "company_id")
    private Company company;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_employment_details_id", referencedColumnName = "id")
    @JsonBackReference(value = "emp_emp_emp_det")
    private EmployeeEmploymentDetails employeeEmploymentDetails;
}