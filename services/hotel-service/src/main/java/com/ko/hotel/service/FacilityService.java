package com.ko.hotel.service;

import com.ko.hotel.dto.response.FacilityResponseDto;
import com.ko.hotel.entity.Facility;

import java.util.List;

public interface FacilityService {
    FacilityResponseDto saveFacility(Facility facility);
    List<FacilityResponseDto> getAllFacilities();
}
