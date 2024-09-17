package com.athomield.gopayroll.entities.employee;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.entities.Employee;
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
    private Employee employee;

    private String employmentCategoryId;

    private String employmentPositionsId;

    private String collectiveConventionsId;

    private String employmentQualificationsId;

    private String departmentId;
}