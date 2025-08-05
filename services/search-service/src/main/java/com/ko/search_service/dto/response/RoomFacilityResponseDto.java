package com.ko.search_service.dto.response;

import com.ko.search_service.entity.RoomFacility;

public class RoomFacilityResponseDto {

    private String facility;
    private String room;
    private boolean isActive;

    // Default constructor
    public RoomFacilityResponseDto() {
    }

    // Parameterized constructor
    public RoomFacilityResponseDto(String facility, String room, boolean isActive) {
        this.facility = facility;
        this.room = room;
        this.isActive = isActive;
    }

    // Static builder method using manual builder
    public static RoomFacilityResponseDto buildDto(RoomFacility roomFacility) {
        return new Builder()
                .room(roomFacility.getRoom().getDisplayName())
                .facility(roomFacility.getFacility().getDisplayName())
                .isActive(roomFacility.isActive())
                .build();
    }

    // Getters
    public String getFacility() {
        return facility;
    }

    public String getRoom() {
        return room;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setters
    public void setFacility(String facility) {
        this.facility = facility;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // ✅ Manual Builder class
    public static class Builder {
        private String facility;
        private String room;
        private boolean isActive;

        public Builder facility(String facility) {
            this.facility = facility;
            return this;
        }

        public Builder room(String room) {
            this.room = room;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public RoomFacilityResponseDto build() {
            return new RoomFacilityResponseDto(facility, room, isActive);
        }
    }
}
