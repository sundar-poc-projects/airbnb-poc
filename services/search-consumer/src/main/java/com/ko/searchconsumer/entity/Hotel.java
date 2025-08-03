package com.ko.searchconsumer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "hotels", writeTypeHint = WriteTypeHint.FALSE)
public class Hotel {

    @Id
    private Long id;

    private String name;

    private Location location;

    private String description;

    private String imageUrl;

    private boolean isActive;

    private List<Room> rooms;

    private List<HotelFacility> hotelFacilities;

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isActive=" + isActive +
                ", rooms=" + rooms +
                ", hotelFacilities=" + hotelFacilities +
                '}';
    }
}
