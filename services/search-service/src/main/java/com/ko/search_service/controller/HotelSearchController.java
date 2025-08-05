package com.ko.search_service.controller;

import com.ko.search_service.dto.response.HotelResponseDto;
import com.ko.search_service.entity.Hotel;
import com.ko.search_service.service.HotelSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelSearchController {

    private final HotelSearchService hotelSearchService;

    public HotelSearchController(HotelSearchService hotelSearchService) {
        this.hotelSearchService = hotelSearchService;
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<HotelResponseDto>> searchByCity(@PathVariable String location) {
        List<Hotel> hotels = hotelSearchService.searchByLocation(location);
        return ResponseEntity.ok(hotels.stream()
                            .map(hotel -> HotelResponseDto.buildDto(hotel))
                            .collect(Collectors.toList())
        );
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAllHotels() {
        List<Hotel> hotels = hotelSearchService.findAll();
        return ResponseEntity.ok(hotels.stream()
                .map(hotel -> HotelResponseDto.buildDto(hotel))
                .collect(Collectors.toList())
        );
    }
}


