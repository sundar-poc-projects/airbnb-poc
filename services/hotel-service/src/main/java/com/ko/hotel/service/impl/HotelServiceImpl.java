package com.ko.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ko.hotel.dto.response.HotelResponseDto;
import com.ko.hotel.entity.Hotel;
import com.ko.hotel.entity.Location;
import com.ko.hotel.kafka.KafkaProducer;
import com.ko.hotel.repository.HotelRepository;
import com.ko.hotel.repository.LocationRepository;
import com.ko.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final LocationRepository locationRepository;

    private final KafkaProducer kafkaProducer;

    private final ObjectMapper objectMapper;

    @Override
    public HotelResponseDto saveHotel(Hotel hotelRequest) {
        Long locationId = hotelRequest.getLocation().getId();
        Location existingLocation = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        hotelRequest.setLocation(existingLocation);
        Hotel savedHotel = hotelRepository.save(hotelRequest);
        log.info("Hotel saved successfully {} ",savedHotel);
        HotelResponseDto hotelResponseDto = HotelResponseDto.buildDto(savedHotel);
        try {
            String hotelJson = objectMapper.writeValueAsString(hotelResponseDto);
            kafkaProducer.sendHotelEvent(hotelJson);
        } catch (Exception e) {
            log.info("Exception occurred during queue insertion. {}",e);
        }
        return hotelResponseDto;
    }

    @Override
    public List<HotelResponseDto> getAllHotels(){
        List<Hotel> hotelList = hotelRepository.findAll();
        return hotelList.stream()
                .map(hotel -> HotelResponseDto.buildDto(hotel))
                .collect(Collectors.toList());
    }
}
