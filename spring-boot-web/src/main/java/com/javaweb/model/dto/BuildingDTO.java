package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BuildingDTO extends AbstractDTO<BuildingDTO> {
    private Long id;
    @NotBlank(message = "Building name must not be blank")
    private String name; // Tên tòa nhà
    @NotBlank(message = "District must not be blank")
    private String district; // Quận
    @NotBlank(message = "Ward must not be blank")
    private String ward; // Phường
    @NotBlank(message = "Street must not be blank")
    private String street; // Đường
    private String structure; // Kết cấu
    private Long numberOfBasement; // Số tầng hầm
    private Long floorArea; // Diện tích sàn
    private String direction; // Hướng
    private String level; // Hạng
    @NotBlank(message = "Rent area must not be blank")
    private String rentArea; // Diện tích thuê
    @NotNull(message = "Rent price must not be null")
    @Min(value = 0, message = "Rent price must not be negative")
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
    @NotBlank(message = "Manager name must not be blank")
    private String managerName; // Tên quản lý
    @NotBlank(message = "Manager phone number must not be blank")
    private String managerPhone; // Số điện thoại quản lý
    private Double brokerageFee; // Phí môi giới
    //    @NotNull(message = "Building type is required")
    @Size(min = 1, message = "Building type is required")
    private List<String> typeCodes; // Loại tòa nhà
    private String note; // Ghi chú

    private String image;
    private String imageBase64;
    private String imageName;

    private Map<String, String> buildingDTOs = new HashMap<>();
}
