package com.ko.hotel.service.impl;

import com.ko.hotel.entity.Facility;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.entity.Room;
import com.ko.hotel.entity.RoomFacility;
import com.ko.hotel.repository.FacilityRepository;
import com.ko.hotel.repository.RoomFacilityRepository;
import com.ko.hotel.repository.RoomRepository;
import com.ko.hotel.service.RoomFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomFacilityServiceImpl implements RoomFacilityService {

    private final RoomFacilityRepository roomFacilityRepository;

    private final RoomRepository roomRepository;

    private final FacilityRepository facilityRepository;

    @Override
    public RoomFacility saveRoomFacility(RoomFacility roomFacility) {
        Room room = roomRepository.findById(roomFacility.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Facility facility = facilityRepository.findById(roomFacility.getFacility().getId())
                .orElseThrow(() -> new RuntimeException("Facility not found"));

        roomFacility.setFacility(facility);
        roomFacility.setRoom(room);
        return roomFacilityRepository.save(roomFacility);
    }

    @Override
    public List<RoomFacility> getAllRoomFacilities() {
        return roomFacilityRepository.findAll();
    }

}
