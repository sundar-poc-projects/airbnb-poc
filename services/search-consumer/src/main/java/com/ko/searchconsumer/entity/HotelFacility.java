package com.ko.searchconsumer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelFacility {

    private Long id;

    private Hotel hotel;

    private Facility facility;

    private boolean isActive;

}
