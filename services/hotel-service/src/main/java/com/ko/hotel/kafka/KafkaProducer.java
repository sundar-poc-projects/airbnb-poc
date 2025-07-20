package com.ko.hotel.kafka;

import com.ko.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "hotel.updated";

    public void sendHotelEvent(String hotel) {
        kafkaTemplate.send(TOPIC, hotel);
        System.out.println("📤 Hotel event sent to Kafka: " + hotel);
    }
}
