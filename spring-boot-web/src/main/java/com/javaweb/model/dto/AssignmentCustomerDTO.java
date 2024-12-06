package com.javaweb.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class AssignmentCustomerDTO {
    @JsonProperty("id")
    @NotNull(message = "Customer id is required")
    private Long customerId;
    private List<Long> staffIds;
}
