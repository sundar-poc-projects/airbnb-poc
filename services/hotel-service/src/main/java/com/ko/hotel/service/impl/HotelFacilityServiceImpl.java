package com.ko.hotel.service.impl;

import com.ko.hotel.entity.Facility;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.entity.HotelFacility;
import com.ko.hotel.repository.FacilityRepository;
import com.ko.hotel.repository.HotelFacilityRepository;
import com.ko.hotel.repository.HotelRepository;
import com.ko.hotel.service.HotelFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelFacilityServiceImpl implements HotelFacilityService {

    private final HotelFacilityRepository hotelFacilityRepository;

    private final HotelRepository hotelRepository;

    private final FacilityRepository facilityRepository;

    @Override
    public HotelFacility saveHotelFacility(HotelFacility hotelFacility) {
        Hotel hotel = hotelRepository.findById(hotelFacility.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        Facility facility = facilityRepository.findById(hotelFacility.getFacility().getId())
                .orElseThrow(() -> new RuntimeException("Facility not found"));

        hotelFacility.setFacility(facility);
        hotelFacility.setHotel(hotel);

        return hotelFacilityRepository.save(hotelFacility);
    }

    @Override
    public List<HotelFacility> getAllHotelFacility() {
        return hotelFacilityRepository.findAll();
    }
}
