package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CustomerDTO extends AbstractDTO{
    @NotBlank(message = "Fullname is required")
    private String fullname;
    private String managementStaff;
    @NotBlank(message = "Phone is required")
    private String phone;
    private String email;
    private String demand;
    private String status;
    private String companyName;
}
