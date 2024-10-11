package com.athomield.gopayroll.entities.dto;

import com.athomield.gopayroll.entities.employeedetails.Department;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartmentRequestBody {
    @JsonProperty("department")
    Department department;
    private long company_id;
}
