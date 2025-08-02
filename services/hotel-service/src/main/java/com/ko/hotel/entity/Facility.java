package com.ko.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "facilities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName;

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
