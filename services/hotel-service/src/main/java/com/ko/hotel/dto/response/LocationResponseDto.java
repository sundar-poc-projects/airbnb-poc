package com.ko.hotel.dto.response;

import com.ko.hotel.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponseDto {

    private String street;

    private String city;

    private String district;

    private String state;

    private String pinCode;

    private double latitude;

    private double longitude;

    public static LocationResponseDto buildDto(Location location){
        return LocationResponseDto.builder()
                .street(location.getStreet())
                .city(location.getCity())
                .district(location.getDistrict())
                .state(location.getState())
                .pinCode(location.getPinCode())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
    }
}
