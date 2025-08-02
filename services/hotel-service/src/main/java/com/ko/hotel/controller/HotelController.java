package com.ko.hotel.controller;

import com.ko.hotel.dto.response.HotelResponseDto;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelResponseDto> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.saveHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

}
