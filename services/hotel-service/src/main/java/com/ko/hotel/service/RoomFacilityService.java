package com.ko.hotel.service;

import com.ko.hotel.dto.response.RoomFacilityResponseDto;
import com.ko.hotel.entity.RoomFacility;

import java.util.List;

public interface RoomFacilityService {
    RoomFacilityResponseDto saveRoomFacility(RoomFacility roomFacility);
    List<RoomFacilityResponseDto> getAllRoomFacilities();
}
