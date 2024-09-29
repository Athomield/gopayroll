package com.athomield.gopayroll.entities.requestbodies;

import com.athomield.gopayroll.entities.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class EmployeeRequestBody {

    private String name;

    private String email;

    private double salary;

    private Long company_id;

    @JsonProperty("address")
    Address address;

    private Long department_id;

}