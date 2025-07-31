package com.ko.hotel.service.impl;

import com.ko.hotel.entity.Hotel;
import com.ko.hotel.entity.Room;
import com.ko.hotel.repository.HotelRepository;
import com.ko.hotel.repository.RoomRepository;
import com.ko.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;

    @Override
    public Room saveRoom(Room room) {
        Hotel hotel = hotelRepository.findById(room.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        room.setHotel(hotel);
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
