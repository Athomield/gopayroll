package com.athomield.gopayroll.entities;
import com.athomield.gopayroll.entities.employeedetails.EmploymentDetails;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employment_details_id", referencedColumnName = "id")
    private EmploymentDetails employmentDetails;

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

}