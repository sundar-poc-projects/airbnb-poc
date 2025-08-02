package com.ko.hotel.service;

import com.ko.hotel.dto.response.HotelFacilityResponseDto;
import com.ko.hotel.entity.HotelFacility;

import java.util.List;

public interface HotelFacilityService {
    HotelFacilityResponseDto saveHotelFacility(HotelFacility hotelFacility);
    List<HotelFacilityResponseDto> getAllHotelFacility();
}
