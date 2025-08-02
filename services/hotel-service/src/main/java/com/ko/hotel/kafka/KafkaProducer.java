package com.ko.hotel.kafka;

import com.ko.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "hotel.updated";

    public void sendHotelEvent(String hotel) {
        kafkaTemplate.send(TOPIC, hotel);
        log.info("Hotel event sent to Kafka : {}",hotel);
    }
}
