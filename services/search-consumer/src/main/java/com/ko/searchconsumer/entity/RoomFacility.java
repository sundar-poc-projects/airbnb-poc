package com.ko.searchconsumer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomFacility {

    private Long id;

    private Facility facility;

    private Room room;

    private boolean isActive;

}
