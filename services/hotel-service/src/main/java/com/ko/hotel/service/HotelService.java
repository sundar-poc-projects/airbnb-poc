package com.ko.hotel.service;

import com.ko.hotel.dto.response.HotelResponseDto;
import com.ko.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {
    HotelResponseDto saveHotel(Hotel hotel);
    List<HotelResponseDto> getAllHotels();
}