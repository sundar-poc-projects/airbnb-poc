package com.ko.hotel.dto.response;

import com.ko.hotel.entity.RoomFacility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomFacilityResponseDto {

    private String facility;

    private String room;

    private boolean isActive;

    public static RoomFacilityResponseDto buildDto(RoomFacility roomFacility){
        return RoomFacilityResponseDto
                .builder()
                .room(roomFacility.getRoom().getDisplayName())
                .facility(roomFacility.getFacility().getDisplayName())
                .isActive(roomFacility.isActive())
                .build();
    }
}
