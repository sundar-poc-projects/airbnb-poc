package com.ko.searchconsumer.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ko.searchconsumer.model.HotelDocument;
import com.ko.searchconsumer.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelEventListener {

    private final HotelRepository hotelRepository;

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "hotel.updated", groupId = "search-consumer-group")
    public void listenHotelUpdate(String hotelStr) {
        System.out.println("Consumed : " + hotelStr);
        try {
            HotelDocument hotelDocument = objectMapper.readValue(hotelStr, HotelDocument.class);
            hotelRepository.save(hotelDocument);
            System.out.println("Hotel indexed in Elasticsearch: " + hotelDocument.getName());
        } catch (JsonProcessingException e) {
            System.err.println("Failed to deserialize hotel JSON: " + e.getMessage());
            // log error and skip message, do not rethrow exception
        } catch (Exception e) {
            System.err.println("Error processing hotel update: " + e.getMessage());
            e.printStackTrace();
            // optionally handle other exceptions as needed
        }
    }

}
