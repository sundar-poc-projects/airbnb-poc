package com.ko.hotel.service.impl;

import com.ko.hotel.dto.response.LocationResponseDto;
import com.ko.hotel.entity.Location;
import com.ko.hotel.repository.LocationRepository;
import com.ko.hotel.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public LocationResponseDto saveLocation(Location location) {
        Location savedLocation = locationRepository.save(location);
        log.info("Location saved successfully {} ",savedLocation);
        return LocationResponseDto.buildDto(savedLocation);
    }

    @Override
    public List<LocationResponseDto> getAllLocations() {
        List<Location> locationList = locationRepository.findAll();
        return locationList.stream()
                    .map(location -> LocationResponseDto.buildDto(location))
                    .collect(Collectors.toList());
    }
}
