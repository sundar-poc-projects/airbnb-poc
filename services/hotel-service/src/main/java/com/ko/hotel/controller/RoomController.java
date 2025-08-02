package com.ko.hotel.controller;

import com.ko.hotel.dto.response.RoomResponseDto;
import com.ko.hotel.entity.Room;
import com.ko.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomResponseDto> createRoom(@RequestBody Room room){
        return ResponseEntity.ok(roomService.saveRoom(room));
    }

    @GetMapping
    public ResponseEntity<List<RoomResponseDto>> getAllRooms(){
        return ResponseEntity.ok(roomService.getAllRooms());
    }
}
