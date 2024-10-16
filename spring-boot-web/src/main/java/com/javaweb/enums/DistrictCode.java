package com.javaweb.enums;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum DistrictCode {
    QUAN_1 ("Quận 1"),
    QUAN_2 ("Quận 2"),
    QUAN_3 ("Quận 3"),
    QUAN_4 ("Quận 4"),
    QUAN_5 ("Quận 5"),
    QUAN_6 ("Quận 6"),
    QUAN_7 ("Quận 7"),
    QUAN_8 ("Quận 8"),
    QUAN_9 ("Quận 9"),
    QUAN_10 ("Quận 10"),
    QUAN_11 ("Quận 11"),
    QUAN_12 ("Quận 12"),
    QUAN_13 ("Quận Bình Thạnh"),
    QUAN_14 ("Quận Gò Vấp"),
    QUAN_15 ("Quận Phú Nhuận"),
    QUAN_16 ("Quận Tân Bình"),
    QUAN_17 ("Quận Tân Phú"),
    QUAN_18 ("Quận Bình Tân"),
    QUAN_19 ("Thành phố Thủ Đức");

    private final String districtName;

    DistrictCode(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public static Map<String, String> type() {
        Map<String, String> listType = new LinkedHashMap<>();
        for (DistrictCode type : DistrictCode.values()) {
            listType.put(type.toString(), type.getDistrictName());
        }
        return listType;
    }
}
