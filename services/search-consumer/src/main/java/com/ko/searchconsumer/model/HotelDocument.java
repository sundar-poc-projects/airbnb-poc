package com.ko.searchconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "hotels")
public class HotelDocument {
    @Id
    private Long id;
    private String name;
    private String location;
    private String description;
    private Integer roomsAvailable;
    private Double pricePerNight;
}
