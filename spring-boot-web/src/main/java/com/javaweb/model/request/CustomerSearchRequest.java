package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSearchRequest{
    private String fullname;
    private String phoneNumber;
    private String email;
    private Long staffId;
}
