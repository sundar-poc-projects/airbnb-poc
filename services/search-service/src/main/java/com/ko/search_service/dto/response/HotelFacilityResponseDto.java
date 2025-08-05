package com.ko.search_service.dto.response;

import com.ko.search_service.entity.HotelFacility;

public class HotelFacilityResponseDto {

    private String hotel;
    private String facility;
    private boolean isActive;

    // Default constructor
    public HotelFacilityResponseDto() {
    }

    // Parameterized constructor
    public HotelFacilityResponseDto(String hotel, String facility, boolean isActive) {
        this.hotel = hotel;
        this.facility = facility;
        this.isActive = isActive;
    }

    // Static method to build DTO from entity
    public static HotelFacilityResponseDto buildDto(HotelFacility hotelFacility) {
        return new Builder()
                .hotel(hotelFacility.getHotel().getName())
                .facility(hotelFacility.getFacility().getDisplayName())
                .isActive(hotelFacility.isActive())
                .build();
    }

    // Getters
    public String getHotel() {
        return hotel;
    }

    public String getFacility() {
        return facility;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setters
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // ✅ Manual Builder class
    public static class Builder {
        private String hotel;
        private String facility;
        private boolean isActive;

        public Builder hotel(String hotel) {
            this.hotel = hotel;
            return this;
        }

        public Builder facility(String facility) {
            this.facility = facility;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public HotelFacilityResponseDto build() {
            return new HotelFacilityResponseDto(hotel, facility, isActive);
        }
    }
}
