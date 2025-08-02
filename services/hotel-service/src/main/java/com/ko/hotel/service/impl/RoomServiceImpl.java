package com.ko.hotel.service.impl;

import com.ko.hotel.dto.response.RoomResponseDto;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.entity.Room;
import com.ko.hotel.repository.HotelRepository;
import com.ko.hotel.repository.RoomRepository;
import com.ko.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;

    @Override
    public RoomResponseDto saveRoom(Room room) {
        Hotel hotel = hotelRepository.findById(room.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        room.setHotel(hotel);
        Room savedRoom = roomRepository.save(room);
        log.info("Room saved successfully {} ",savedRoom);
        return RoomResponseDto.buildDto(savedRoom);
    }

    @Override
    public List<RoomResponseDto> getAllRooms() {
        List<Room> roomList = roomRepository.findAll();
        return roomList
                .stream()
                .map(room -> RoomResponseDto.buildDto(room))
                .collect(Collectors.toList());
    }
}
