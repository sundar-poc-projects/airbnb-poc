package com.ko.searchconsumer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    private Long id;

    private String street;

    private String city;

    private String district;

    private String state;

    private String pinCode;

    private double latitude;

    private double longitude;
}
