package com.ko.search_service.dto.response;

import com.ko.search_service.entity.Room;

import java.util.List;
import java.util.stream.Collectors;

public class RoomResponseDto {

    private String hotel;
    private String displayName;
    private boolean isActive;
    private int quantity;
    private double price;
    private List<RoomFacilityResponseDto> roomFacilities;

    // Default constructor
    public RoomResponseDto() {
    }

    // All-args constructor
    public RoomResponseDto(String hotel, String displayName, boolean isActive,
                           int quantity, double price, List<RoomFacilityResponseDto> roomFacilities) {
        this.hotel = hotel;
        this.displayName = displayName;
        this.isActive = isActive;
        this.quantity = quantity;
        this.price = price;
        this.roomFacilities = roomFacilities;
    }

    // Getters and setters
    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<RoomFacilityResponseDto> getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(List<RoomFacilityResponseDto> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    // Manual builder
    public static class Builder {
        private String hotel;
        private String displayName;
        private boolean isActive;
        private int quantity;
        private double price;
        private List<RoomFacilityResponseDto> roomFacilities;

        public Builder hotel(String hotel) {
            this.hotel = hotel;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder roomFacilities(List<RoomFacilityResponseDto> roomFacilities) {
            this.roomFacilities = roomFacilities;
            return this;
        }

        public RoomResponseDto build() {
            return new RoomResponseDto(hotel, displayName, isActive, quantity, price, roomFacilities);
        }
    }

    // Static buildDto method
    public static RoomResponseDto buildDto(Room room) {
        Builder builder = new Builder()
                .hotel(room.getHotel().getName())
                .displayName(room.getDisplayName())
                .isActive(room.isActive())
                .quantity(room.getQuantity())
                .price(room.getPrice());

        if (room.getRoomFacilities() != null) {
            builder.roomFacilities(
                    room.getRoomFacilities()
                            .stream()
                            .map(RoomFacilityResponseDto::buildDto)
                            .collect(Collectors.toList())
            );
        }

        return builder.build();
    }
}
