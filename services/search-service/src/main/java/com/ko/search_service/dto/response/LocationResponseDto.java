package com.ko.search_service.dto.response;

import com.ko.search_service.entity.Location;

public class LocationResponseDto {

    private String street;
    private String city;
    private String district;
    private String state;
    private String pinCode;
    private double latitude;
    private double longitude;

    // Default constructor
    public LocationResponseDto() {
    }

    // All-args constructor
    public LocationResponseDto(String street, String city, String district, String state,
                               String pinCode, double latitude, double longitude) {
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
        this.pinCode = pinCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // Manual builder
    public static class Builder {
        private String street;
        private String city;
        private String district;
        private String state;
        private String pinCode;
        private double latitude;
        private double longitude;

        public Builder street(String street) {
            this.street = street;
            return this;
        }
        public Builder city(String city) {
            this.city = city;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder state(String state) {
            this.state = state;
            return this;
        }
        public Builder pinCode(String pinCode) {
            this.pinCode = pinCode;
            return this;
        }
        public Builder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }
        public Builder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public LocationResponseDto build() {
            return new LocationResponseDto(street, city, district, state, pinCode, latitude, longitude);
        }
    }

    // Static method to build DTO from entity
    public static LocationResponseDto buildDto(Location location) {
        return new Builder()
                .street(location.getStreet())
                .city(location.getCity())
                .district(location.getDistrict())
                .state(location.getState())
                .pinCode(location.getPinCode())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
    }
}
