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

    private long employment_category_id;

    private long employment_positions_id;

    private long collective_conventions_id;

    private long employment_qualifications_id;

    private long department_id;
}