package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class TransactionDTO{
    private Long id;

    @NotBlank(message = "Transaction note is required")
    private String note;

    private String code;

    @NotNull(message = "Transaction customer id is required")
    private Long customerId;

    private Long staffId;

    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
