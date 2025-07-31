package com.ko.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Hotel hotel;

    private String displayName;

    private boolean isActive;

    private int quantity;

    private double price;

    @OneToMany(mappedBy = "room", cascade =  CascadeType.ALL)
    @JsonIgnore
    private List<RoomFacility> roomFacilities;
}
