package com.ko.hotel.service;

import com.ko.hotel.entity.RoomFacility;

import java.util.List;

public interface RoomFacilityService {
    RoomFacility saveRoomFacility(RoomFacility roomFacility);
    List<RoomFacility> getAllRoomFacilities();
}
