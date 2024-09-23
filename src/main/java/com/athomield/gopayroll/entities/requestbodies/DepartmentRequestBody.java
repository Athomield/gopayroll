package com.athomield.gopayroll.entities.requestbodies;

import lombok.Data;

@Data
public class DepartmentRequestBody {
    private String code;

    private String description;
    private long company_id;
}
