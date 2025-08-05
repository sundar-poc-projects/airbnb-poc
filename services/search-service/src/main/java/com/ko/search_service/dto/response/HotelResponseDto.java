package com.ko.search_service.dto.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ko.search_service.entity.Hotel;

import java.util.List;
import java.util.stream.Collectors;

public class HotelResponseDto {

    private String name;
    private LocationResponseDto location;
    private String description;
    private String imageUrl;
    private boolean isActive;

    @JsonManagedReference("hotel-rooms")
    private List<RoomResponseDto> rooms;

    @JsonManagedReference("hotel-facilities")
    private List<HotelFacilityResponseDto> hotelFacilities;

    // Default constructor
    public HotelResponseDto() {
    }

    // All args constructor
    public HotelResponseDto(String name, LocationResponseDto location, String description,
                            String imageUrl, boolean isActive, List<RoomResponseDto> rooms,
                            List<HotelFacilityResponseDto> hotelFacilities) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isActive = isActive;
        this.rooms = rooms;
        this.hotelFacilities = hotelFacilities;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationResponseDto getLocation() {
        return location;
    }

    public void setLocation(LocationResponseDto location) {
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

    public List<RoomResponseDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomResponseDto> rooms) {
        this.rooms = rooms;
    }

    public List<HotelFacilityResponseDto> getHotelFacilities() {
        return hotelFacilities;
    }

    public void setHotelFacilities(List<HotelFacilityResponseDto> hotelFacilities) {
        this.hotelFacilities = hotelFacilities;
    }

    // Static buildDto method using manual builder
    public static HotelResponseDto buildDto(Hotel hotel) {
        Builder builder = new Builder()
                .name(hotel.getName())
                .location(LocationResponseDto.buildDto(hotel.getLocation()))
                .description(hotel.getDescription())
                .imageUrl(hotel.getImageUrl())
                .isActive(hotel.isActive());

        if (hotel.getRooms() != null) {
            builder.rooms(
                    hotel.getRooms()
                            .stream()
                            .map(RoomResponseDto::buildDto)
                            .collect(Collectors.toList())
            );
        }

        if (hotel.getHotelFacilities() != null) {
            builder.hotelFacilities(
                    hotel.getHotelFacilities()
                            .stream()
                            .map(HotelFacilityResponseDto::buildDto)
                            .collect(Collectors.toList())
            );
        }

        return builder.build();
    }

    // Manual builder class
    public static class Builder {
        private String name;
        private LocationResponseDto location;
        private String description;
        private String imageUrl;
        private boolean isActive;
        private List<RoomResponseDto> rooms;
        private List<HotelFacilityResponseDto> hotelFacilities;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(LocationResponseDto location) {
            this.location = location;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder rooms(List<RoomResponseDto> rooms) {
            this.rooms = rooms;
            return this;
        }

        public Builder hotelFacilities(List<HotelFacilityResponseDto> hotelFacilities) {
            this.hotelFacilities = hotelFacilities;
            return this;
        }

        public HotelResponseDto build() {
            return new HotelResponseDto(name, location, description, imageUrl, isActive, rooms, hotelFacilities);
        }
    }
}
