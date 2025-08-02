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
public class RoomFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Facility facility;

    @ManyToOne
    @JsonBackReference("room-facilities")
    private Room room;

    private boolean isActive;

    @Override
    public String toString() {
        return "RoomFacility{" +
                "id=" + id +
                ", facility=" + facility +
                ", isActive=" + isActive +
                '}';
    }
}
