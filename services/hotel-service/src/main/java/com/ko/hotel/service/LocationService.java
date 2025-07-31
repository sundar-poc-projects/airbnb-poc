package com.ko.hotel.service;

import com.ko.hotel.entity.Location;

import java.util.List;

public interface LocationService {
    Location saveLocation(Location location);
    List<Location> getAllLocations();
}
