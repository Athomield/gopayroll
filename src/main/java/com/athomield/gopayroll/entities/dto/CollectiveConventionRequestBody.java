package com.athomield.gopayroll.entities.dto;

import com.athomield.gopayroll.entities.employeedetails.CollectiveConvention;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CollectiveConventionRequestBody {
    @JsonProperty("collective_convention")
    CollectiveConvention collectiveConvention;

    private long company_id;
}
