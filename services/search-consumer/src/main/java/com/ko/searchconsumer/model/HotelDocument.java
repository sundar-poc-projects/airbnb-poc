package com.ko.searchconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "hotels", writeTypeHint = WriteTypeHint.FALSE)
public class HotelDocument {
    @Id
    private Long id;
    private String name;
    private String location;
    private String description;
    private Integer roomsAvailable;
    private Double pricePerNight;
}
