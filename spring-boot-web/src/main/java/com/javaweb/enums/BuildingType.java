package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;

public enum BuildingType {
    TANG_TRET ("Tầng trệt"),
    NGUYEN_CAN ("Nguyên căn"),
    NOI_THAT ("Nội thất");

    private final String code;

    BuildingType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Map<String, String> type() {
        Map<String, String> listType = new HashMap<String, String>();
        for (BuildingType type : BuildingType.values()) {
            listType.put(type.toString(), type.getCode());
        }
        return listType;
    }
}
