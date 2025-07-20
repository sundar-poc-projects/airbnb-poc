package com.ko.hotel.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.kafka.KafkaProducer;
import com.ko.hotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    private final KafkaProducer kafkaProducer;

    private final ObjectMapper objectMapper;

    public Hotel saveHotel(Hotel hotel) {
        Hotel saved = hotelRepository.save(hotel);
        try {
            // Convert Hotel object to JSON string
            String hotelJson = objectMapper.writeValueAsString(saved);
            kafkaProducer.sendHotelEvent(hotelJson); // send JSON string instead of object
        } catch (Exception e) {
            // Handle or log the exception as needed
            e.printStackTrace();
        }
        return saved;
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }
}
