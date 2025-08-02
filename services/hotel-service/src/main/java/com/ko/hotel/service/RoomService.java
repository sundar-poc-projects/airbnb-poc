package com.ko.hotel.service;

import com.ko.hotel.dto.response.RoomResponseDto;
import com.ko.hotel.entity.Room;

import java.util.List;

public interface RoomService {
    RoomResponseDto saveRoom(Room room);
    List<RoomResponseDto> getAllRooms();
}