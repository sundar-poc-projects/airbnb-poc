package com.ko.search_service.dto.response;

import com.ko.search_service.entity.Facility;

public class FacilityResponseDto {

    private String displayName;

    // Default constructor
    public FacilityResponseDto() {
    }

    // Parameterized constructor
    public FacilityResponseDto(String displayName) {
        this.displayName = displayName;
    }

    // Static factory method using builder
    public static FacilityResponseDto buildDto(Facility facility) {
        return new Builder()
                .displayName(facility.getDisplayName())
                .build();
    }

    // Getter
    public String getDisplayName() {
        return displayName;
    }

    // Setter
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    // ✅ Manual Builder
    public static class Builder {
        private String displayName;

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public FacilityResponseDto build() {
            return new FacilityResponseDto(displayName);
        }
    }
}
