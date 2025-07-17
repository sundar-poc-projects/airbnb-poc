package com.ko.hotel.controller;

import com.ko.hotel.entity.Hotel;
import com.ko.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotel(){
        return hotelService.getAllHotels();
    }

}
