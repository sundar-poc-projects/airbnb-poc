package com.ko.booking_service.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "booking.created";  // or booking.updated, etc.


    public BookingKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBookingEvent(String bookingJson) {
        kafkaTemplate.send(TOPIC, bookingJson);
        System.out.println("📤 Booking event sent to Kafka: " + bookingJson);
    }
}
