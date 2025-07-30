package com.ko.booking_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("hotelId")
    private Long hotelId;

    @JsonProperty("checkInDate")
    private LocalDate checkInDate;

    @JsonProperty("checkOutDate")
    private LocalDate checkOutDate;

    @JsonProperty("roomsBooked")
    private Integer roomsBooked;

    @JsonProperty("totalPrice")
    private Double totalPrice;

    @JsonProperty("status")
    private String status;
}
