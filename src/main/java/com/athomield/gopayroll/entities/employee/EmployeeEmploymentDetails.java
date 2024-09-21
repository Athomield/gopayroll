package com.athomield.gopayroll.entities.employee;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.entities.Employee;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmployeeEmploymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "employeeEmploymentDetails")
    @JsonManagedReference
    private Employee employee;

    private long employmentCategoryId;

    private long employmentPositionsId;

    private long collectiveConventionsId;

    private long employmentQualificationsId;

    private long departmentId;
}