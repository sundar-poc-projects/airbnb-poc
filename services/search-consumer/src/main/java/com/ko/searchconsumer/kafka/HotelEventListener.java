package com.ko.searchconsumer.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ko.searchconsumer.entity.Hotel;
import com.ko.searchconsumer.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelEventListener {

    private final HotelRepository hotelRepository;

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "hotel.updated", groupId = "search-consumer-group")
    public void listenHotelUpdate(String hotelStr) {
        log.info("consumed message {}", hotelStr);
        try {
            Hotel hotelDocument = objectMapper.readValue(hotelStr, Hotel.class);
            hotelRepository.save(hotelDocument);
            log.info("Hotel indexed in Elasticsearch: {} " ,hotelDocument.getName());
        } catch (JsonProcessingException e) {
            log.info("Failed to deserialize hotel JSON : {} " + e.getMessage(), e);
        } catch (Exception e) {
            log.info("Error processing hotel update: {}", e.getMessage(), e);
        }
    }

}
