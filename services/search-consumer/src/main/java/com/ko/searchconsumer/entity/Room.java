package com.ko.searchconsumer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Room {

    private Long id;

    private Hotel hotel;

    private String displayName;

    private boolean isActive;

    private int quantity;

    private double price;

    private List<RoomFacility> roomFacilities;
}
