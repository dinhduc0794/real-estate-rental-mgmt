package com.javaweb.model.request;

import com.javaweb.model.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSearchRequest extends AbstractDTO {
    private String fullname;
    private String phone;
    private String email;
    private Long staffId;
    private String status;
    private String createdBy;
}
