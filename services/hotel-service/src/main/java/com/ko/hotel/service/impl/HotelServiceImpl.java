package com.ko.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.entity.Location;
import com.ko.hotel.kafka.KafkaProducer;
import com.ko.hotel.repository.HotelRepository;
import com.ko.hotel.repository.LocationRepository;
import com.ko.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final LocationRepository locationRepository;

    private final KafkaProducer kafkaProducer;

    private final ObjectMapper objectMapper;

    @Override
    public Hotel saveHotel(Hotel hotelRequest) {
        Long locationId = hotelRequest.getLocation().getId();
        Location existingLocation = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        hotelRequest.setLocation(existingLocation);
        Hotel saved = hotelRepository.save(hotelRequest);
//        try {
//            // Convert Hotel object to JSON string
//            String hotelJson = objectMapper.writeValueAsString(saved);
//            kafkaProducer.sendHotelEvent(hotelJson); // send JSON string instead of object
//        } catch (Exception e) {
//            // Handle or log the exception as needed
//            e.printStackTrace();
//        }
        return saved;
    }

    @Override
    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }
}
