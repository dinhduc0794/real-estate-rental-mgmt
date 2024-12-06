package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {
    DANG_XU_LY("Đang xử lý"),
    DA_XU_LY("Đã xử lý"),
    CHUA_XU_LY("Chưa xử lý");

    private final String statusName;
    StatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public static Map<String, String> type() {
        Map<String, String> listType = new HashMap<>();
        for (StatusEnum statusEnum : StatusEnum.values()) {
            listType.put(statusEnum.getStatusName(), statusEnum.statusName);
        }
        return listType;
    }
}
