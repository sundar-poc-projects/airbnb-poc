package com.ko.hotel.service;

import com.ko.hotel.entity.Room;

import java.util.List;

public interface RoomService {
    Room saveRoom(Room room);
    List<Room> getAllRooms();
}