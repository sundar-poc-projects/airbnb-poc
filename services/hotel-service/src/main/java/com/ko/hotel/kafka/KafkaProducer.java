package com.ko.hotel.kafka;

import com.ko.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Hotel> kafkaTemplate;
    private static final String TOPIC = "hotel.updated";

    public void sendHotelEvent(Hotel hotel) {
        kafkaTemplate.send(TOPIC, hotel);
        System.out.println("📤 Hotel event sent to Kafka: " + hotel.getName());
    }
}
