package com.athomield.gopayroll.entities.dto;

import lombok.Data;

@Data
public class DepartmentRequestBody {
    private String code;

    private String description;
    private long company_id;
}
