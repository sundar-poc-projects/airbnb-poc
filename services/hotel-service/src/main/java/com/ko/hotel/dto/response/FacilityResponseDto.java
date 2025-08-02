package com.ko.hotel.dto.response;

import com.ko.hotel.entity.Facility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacilityResponseDto {

    private String displayName;

    public static FacilityResponseDto buildDto(Facility facility){
        return FacilityResponseDto
                .builder()
                .displayName(facility.getDisplayName())
                .build();
    }
}
