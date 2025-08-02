package com.ko.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference("hotel-rooms")
    private Hotel hotel;

    private String displayName;

    private boolean isActive;

    private int quantity;

    private double price;

    @OneToMany(mappedBy = "room", cascade =  CascadeType.ALL)
    @JsonManagedReference("room-facilities")
    private List<RoomFacility> roomFacilities;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", isActive=" + isActive +
                ", quantity=" + quantity +
                ", price=" + price +
                ", roomFacilities=" + roomFacilities +
                '}';
    }
}
