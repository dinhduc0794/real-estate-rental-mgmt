package com.javaweb.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class AssignmentBuildingDTO {
    @JsonProperty("id")
    @NotNull(message = "Building id is required")
    private Long buildingId;
    private List<Long> staffIds;
}
