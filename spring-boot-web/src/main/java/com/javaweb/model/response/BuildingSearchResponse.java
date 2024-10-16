package com.javaweb.model.response;

import com.javaweb.model.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingSearchResponse extends AbstractDTO {
    private String name;
    private String address;
    private Long numberOfBasement;
    private String managerName;
    private String managerPhone;
    private Long floorArea;
    private Long rentArea;  //String
    private Long emptyArea;  //String
    private Long rentPrice;
    private Long serviceFee;    //String
    private Double brokerageFee;
}
