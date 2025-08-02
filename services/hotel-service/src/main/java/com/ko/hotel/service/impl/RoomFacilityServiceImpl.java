package com.ko.hotel.service.impl;

import com.ko.hotel.dto.response.RoomFacilityResponseDto;
import com.ko.hotel.entity.Facility;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.entity.Room;
import com.ko.hotel.entity.RoomFacility;
import com.ko.hotel.repository.FacilityRepository;
import com.ko.hotel.repository.RoomFacilityRepository;
import com.ko.hotel.repository.RoomRepository;
import com.ko.hotel.service.RoomFacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomFacilityServiceImpl implements RoomFacilityService {

    private final RoomFacilityRepository roomFacilityRepository;

    private final RoomRepository roomRepository;

    private final FacilityRepository facilityRepository;

    @Override
    public RoomFacilityResponseDto saveRoomFacility(RoomFacility roomFacility) {
        Room room = roomRepository.findById(roomFacility.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Facility facility = facilityRepository.findById(roomFacility.getFacility().getId())
                .orElseThrow(() -> new RuntimeException("Facility not found"));

        roomFacility.setFacility(facility);
        roomFacility.setRoom(room);
        RoomFacility savedRoomFacility = roomFacilityRepository.save(roomFacility);
        log.info("RoomFacility saved successfully {} ",savedRoomFacility);
        return RoomFacilityResponseDto.buildDto(savedRoomFacility);
    }

    @Override
    public List<RoomFacilityResponseDto> getAllRoomFacilities() {
        List<RoomFacility> roomFacilityList = roomFacilityRepository.findAll();
        return roomFacilityList
                .stream()
                .map(roomFacility -> RoomFacilityResponseDto.buildDto(roomFacility))
                .collect(Collectors.toList());
    }
}
