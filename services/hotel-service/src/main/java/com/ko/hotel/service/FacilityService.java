package com.ko.hotel.service;

import com.ko.hotel.entity.Facility;

import java.util.List;

public interface FacilityService {
    Facility saveFacility(Facility facility);
    List<Facility> getAllFacilities();
}
