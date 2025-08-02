package com.ko.hotel.service;

import com.ko.hotel.dto.response.LocationResponseDto;
import com.ko.hotel.entity.Location;

import java.util.List;

public interface LocationService {
    LocationResponseDto saveLocation(Location location);
    List<LocationResponseDto> getAllLocations();
}
