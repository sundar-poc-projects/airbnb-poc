package com.ko.hotel.dto.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ko.hotel.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelResponseDto {

    private String name;

    private LocationResponseDto location;

    private String description;

    private String imageUrl;

    private boolean isActive;

    @JsonManagedReference("hotel-rooms")
    private List<RoomResponseDto> rooms;

    @JsonManagedReference("hotel-facilities")
    private List<HotelFacilityResponseDto> hotelFacilities;

    public static HotelResponseDto buildDto(Hotel hotel){
        HotelResponseDtoBuilder builder = HotelResponseDto.builder()
                .name(hotel.getName())
                .location(LocationResponseDto.buildDto(hotel.getLocation()))
                .description(hotel.getDescription())
                .imageUrl(hotel.getImageUrl())
                .isActive(hotel.isActive());
                if(hotel.getRooms() != null) {
                    builder.rooms(
                            hotel.getRooms()
                                    .stream()
                                    .map(room -> RoomResponseDto.buildDto(room))
                                    .collect(Collectors.toList()));
                }
                if(hotel.getHotelFacilities() != null) {
                    builder.hotelFacilities(
                            hotel.getHotelFacilities()
                                    .stream()
                                    .map(facility -> HotelFacilityResponseDto.buildDto(facility))
                                    .collect(Collectors.toList()));
                }
                return builder.build();
    }
}
