package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BuildingDTO extends AbstractDTO {
    private Long id;
    private String name; // Tên tòa nhà
    private String district; // Quận
    private String ward; // Phường
    private String street; // Đường
    private String structure; // Kết cấu
    private Long numberOfBasement; // Số tầng hầm
    private Long floorArea; // Diện tích sàn
    private String direction; // Hướng
    private String level; // Hạng
    private String rentArea; // Diện tích thuê
    private Long rentPrice; // Giá thuê
    private String rentPriceDescription; // Mô tả giá
    private String serviceFee; // Phí dịch vụ
    private String carFee; // Phí ô tô
    private String motoFee; // Phí mô tô
    private String overtimeFee; // Phí ngoài giờ
    private String electricityFee; // Tiền điện
    private String deposit; // Đặt cọc
    private String payment; // Thanh toán
    private String rentTime; // Thời hạn thuê
    private String decorationTime; // Thời gian trang trí
    private String managerName; // Tên quản lý
    private String managerPhone; // Số điện thoại quản lý
    private Double brokerageFee; // Phí môi giới
    private List<String> typeCodes; // Loại tòa nhà
    private String note; // Ghi chú

    private String image;
    private String imageBase64;
    private String imageName;

    private Map<String, String> buildingDTOs = new HashMap<>();
}
