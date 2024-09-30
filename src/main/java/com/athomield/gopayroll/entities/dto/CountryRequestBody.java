package com.athomield.gopayroll.entities.dto;

import lombok.Data;

@Data
public class CountryRequestBody {
    private String code;

    private String name;
    private long company_id;
}
