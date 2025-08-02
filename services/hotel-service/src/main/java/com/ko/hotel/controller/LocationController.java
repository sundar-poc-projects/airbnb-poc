package com.ko.hotel.controller;

import com.ko.hotel.dto.response.LocationResponseDto;
import com.ko.hotel.entity.Location;
import com.ko.hotel.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationResponseDto> createLocation(@RequestBody Location location){
        return ResponseEntity.ok(locationService.saveLocation(location));
    }

    @GetMapping
    public ResponseEntity<List<LocationResponseDto>> getAllLocations(){
        return ResponseEntity.ok(locationService.getAllLocations());
    }
}
