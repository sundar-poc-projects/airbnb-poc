package com.ko.hotel.dto.response;

import com.ko.hotel.entity.HotelFacility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelFacilityResponseDto {

    private String hotel;

    private String facility;

    private boolean isActive;

    public static HotelFacilityResponseDto buildDto(HotelFacility hotelFacility){
        return HotelFacilityResponseDto
                .builder()
                .hotel(hotelFacility.getHotel().getName())
                .facility(hotelFacility.getFacility().getDisplayName())
                .isActive(hotelFacility.isActive())
                .build();
    }
}
