package com.ko.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference("hotel-facilities")
    private Hotel hotel;

    @ManyToOne
    private Facility facility;

    private boolean isActive;

    @Override
    public String toString() {
        return "HotelFacility{" +
                "id=" + id +
                ", facility=" + facility +
                ", isActive=" + isActive +
                '}';
    }
}
