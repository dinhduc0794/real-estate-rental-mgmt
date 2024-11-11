package com.javaweb.repository;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {
    void deleteByBuilding_IdIn(List<Long> buildingIds);     // Xóa tất cả rentarea entity mà có quan hệ với building entity có id trong list buildingIds
    void deleteByBuilding_Id(Long buildingId);
    void deleteByBuilding(BuildingEntity building);
}
