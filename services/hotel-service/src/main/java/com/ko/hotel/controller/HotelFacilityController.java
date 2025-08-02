package com.ko.hotel.controller;

import com.ko.hotel.dto.response.HotelFacilityResponseDto;
import com.ko.hotel.entity.HotelFacility;
import com.ko.hotel.service.HotelFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-facility")
@RequiredArgsConstructor
public class HotelFacilityController {

    private final HotelFacilityService hotelFacilityService;

    @PostMapping
    public ResponseEntity<HotelFacilityResponseDto> createHotelFacility(@RequestBody HotelFacility hotelFacility){
        return ResponseEntity.ok(hotelFacilityService.saveHotelFacility(hotelFacility));
    }

    @GetMapping
    public ResponseEntity<List<HotelFacilityResponseDto>> getAllHotelFacilities(){
        return ResponseEntity.ok(hotelFacilityService.getAllHotelFacility());
    }
}
