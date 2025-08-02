package com.ko.hotel.service.impl;

import com.ko.hotel.dto.response.HotelFacilityResponseDto;
import com.ko.hotel.entity.Facility;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.entity.HotelFacility;
import com.ko.hotel.repository.FacilityRepository;
import com.ko.hotel.repository.HotelFacilityRepository;
import com.ko.hotel.repository.HotelRepository;
import com.ko.hotel.service.HotelFacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelFacilityServiceImpl implements HotelFacilityService {

    private final HotelFacilityRepository hotelFacilityRepository;

    private final HotelRepository hotelRepository;

    private final FacilityRepository facilityRepository;

    @Override
    public HotelFacilityResponseDto saveHotelFacility(HotelFacility hotelFacility) {
        Hotel hotel = hotelRepository.findById(hotelFacility.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        Facility facility = facilityRepository.findById(hotelFacility.getFacility().getId())
                .orElseThrow(() -> new RuntimeException("Facility not found"));

        hotelFacility.setFacility(facility);
        hotelFacility.setHotel(hotel);

        HotelFacility savedHotelFacility = hotelFacilityRepository.save(hotelFacility);
        log.info("HotelFacility saved successfully {} ",savedHotelFacility);
        return HotelFacilityResponseDto.buildDto(savedHotelFacility);
    }

    @Override
    public List<HotelFacilityResponseDto> getAllHotelFacility() {
        List<HotelFacility> hotelFacilities = hotelFacilityRepository.findAll();
        return hotelFacilities
                .stream()
                .map(hotelFacility -> HotelFacilityResponseDto.buildDto(hotelFacility))
                .collect(Collectors.toList());
    }
}
