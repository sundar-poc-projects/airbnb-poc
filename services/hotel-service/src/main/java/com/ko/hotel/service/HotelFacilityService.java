package com.ko.hotel.service;

import com.ko.hotel.entity.HotelFacility;

import java.util.List;

public interface HotelFacilityService {
    HotelFacility saveHotelFacility(HotelFacility hotelFacility);
    List<HotelFacility> getAllHotelFacility();
}
