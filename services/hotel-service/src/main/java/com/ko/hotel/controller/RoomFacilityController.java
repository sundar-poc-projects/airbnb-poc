package com.ko.hotel.controller;

import com.ko.hotel.dto.response.RoomFacilityResponseDto;
import com.ko.hotel.entity.RoomFacility;
import com.ko.hotel.service.RoomFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-facility")
@RequiredArgsConstructor
public class RoomFacilityController {

    private final RoomFacilityService roomFacilityService;

    @PostMapping
    public ResponseEntity<RoomFacilityResponseDto> createRoomFacility(@RequestBody RoomFacility roomFacility){
        return ResponseEntity.ok(roomFacilityService.saveRoomFacility(roomFacility));
    }

    @GetMapping
    public ResponseEntity<List<RoomFacilityResponseDto>> getAllRoomFacilities(){
        return ResponseEntity.ok(roomFacilityService.getAllRoomFacilities());
    }
}
