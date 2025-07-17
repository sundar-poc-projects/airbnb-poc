package com.ko.hotel.service;

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

    public Hotel saveHotel(Hotel hotel) {
        Hotel saved = hotelRepository.save(hotel);
        kafkaProducer.sendHotelEvent(saved); // Send event after saving
        return saved;
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }
}
