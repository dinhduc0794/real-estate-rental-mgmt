package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CustomerDTO extends AbstractDTO<CustomerDTO> {
    @NotBlank(message = "Customer fullname is required")
    private String fullname;
    private String managementStaff;
    @NotBlank(message = "Customer phone numer is required")
    private String phone;
    @NotBlank(message = "Customer email is required")
    private String email;
    private String demand;
    private String status;
    private String companyName;
}
