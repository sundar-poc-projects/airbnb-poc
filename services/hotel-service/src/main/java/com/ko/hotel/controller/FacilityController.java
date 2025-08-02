package com.ko.hotel.controller;

import com.ko.hotel.dto.response.FacilityResponseDto;
import com.ko.hotel.entity.Facility;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facility")
@RequiredArgsConstructor
public class FacilityController {
    private final FacilityService facilityService;
    @PostMapping
    public ResponseEntity<FacilityResponseDto> createFacility(@RequestBody Facility facility) {
        return ResponseEntity.ok(facilityService.saveFacility(facility));
    }

    @GetMapping
    public ResponseEntity<List<FacilityResponseDto>> getAllFacilities(){
        return ResponseEntity.ok(facilityService.getAllFacilities());
    }
}
