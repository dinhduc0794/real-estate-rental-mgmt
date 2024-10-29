package com.javaweb.service;

import com.javaweb.model.response.BuildingSearchResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> typeCodes);
}
