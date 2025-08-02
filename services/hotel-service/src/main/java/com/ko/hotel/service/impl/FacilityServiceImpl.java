package com.ko.hotel.service.impl;

import com.ko.hotel.dto.response.FacilityResponseDto;
import com.ko.hotel.entity.Facility;
import com.ko.hotel.repository.FacilityRepository;
import com.ko.hotel.service.FacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FacilityServiceImpl implements FacilityService {
    private final FacilityRepository facilityRepository;

    @Override
    public FacilityResponseDto saveFacility(Facility facility) {
        Facility savedFacility = facilityRepository.save(facility);
        log.info("Facility saved successfully {} ",savedFacility);
        return FacilityResponseDto.buildDto(savedFacility);
    }

    @Override
    public List<FacilityResponseDto> getAllFacilities() {
        List<Facility> facilityList = facilityRepository.findAll();
        return facilityList.stream()
                .map(facility -> FacilityResponseDto.buildDto(facility))
                .collect(Collectors.toList());
    }
}
