package com.athomield.gopayroll.entities.dto;

import lombok.Data;

@Data
public class CivilityRequestBody {
    private String code;

    private String name;
    private long company_id;
}
