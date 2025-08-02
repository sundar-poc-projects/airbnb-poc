package com.ko.hotel.dto.response;



import com.ko.hotel.entity.Room;
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
public class RoomResponseDto {

    private String hotel;

    private String displayName;

    private boolean isActive;

    private int quantity;

    private double price;

    private List<RoomFacilityResponseDto> roomFacilities;

    public static RoomResponseDto buildDto(Room room){
        RoomResponseDtoBuilder builder = RoomResponseDto.builder()
                .hotel(room.getHotel().getName())
                .displayName(room.getDisplayName())
                .isActive(room.isActive())
                .quantity(room.getQuantity())
                .price(room.getPrice());

                if(room.getRoomFacilities() != null) {
                    builder.roomFacilities(
                            room.getRoomFacilities()
                                    .stream()
                                    .map(facility -> RoomFacilityResponseDto.buildDto(facility))
                                    .collect(Collectors.toList())
                    );
                }
                return builder.build();
    }
}
