package com.athomield.gopayroll.entities.dto;

import com.athomield.gopayroll.entities.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeRequestBody {

    private String name;
    private String last_name;

    private String email;

    private Long company_id;

    @JsonProperty("address")
    Address address;

    private Long department_id;

}