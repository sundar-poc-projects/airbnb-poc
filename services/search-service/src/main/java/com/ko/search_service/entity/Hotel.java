package com.ko.search_service.entity;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<HotelFacility> getHotelFacilities() {
        return hotelFacilities;
    }

    public void setHotelFacilities(List<HotelFacility> hotelFacilities) {
        this.hotelFacilities = hotelFacilities;
    }

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
