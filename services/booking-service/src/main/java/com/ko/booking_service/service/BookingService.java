package com.ko.booking_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ko.booking_service.entity.Booking;
import com.ko.booking_service.kafka.BookingKafkaProducer;
import com.ko.booking_service.repository.BookingRepository;
import org.springframework.data.redis.core.ValueOperations;
import java.time.Duration;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingKafkaProducer bookingKafkaProducer;
    private final ObjectMapper objectMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    public BookingService(BookingRepository bookingRepository, BookingKafkaProducer bookingKafkaProducer,
                          ObjectMapper objectMapper, RedisTemplate<String, Object> redisTemplate) {
        this.bookingRepository = bookingRepository;
        this.bookingKafkaProducer = bookingKafkaProducer;
        this.objectMapper = objectMapper;
        this.redisTemplate = redisTemplate;
    }

    public Booking createBooking(Booking booking) {
        Booking savedBooking = bookingRepository.save(booking);
        try {
            String bookingJson = objectMapper.writeValueAsString(savedBooking);
            bookingKafkaProducer.sendBookingEvent(bookingJson);

            // Insert into Redis until checkoutDate
            ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
            String redisKey = "booking:" + savedBooking.getId();
            System.out.println("RedisKey inserted :: "+redisKey);
            LocalDate checkout = savedBooking.getCheckOutDate();
            long secondsToExpire = 0;

            if (checkout.isAfter(LocalDate.now())) {
                secondsToExpire = Duration.between(
                        LocalDate.now().atStartOfDay(),
                        checkout.atStartOfDay()
                ).getSeconds();
            }
            System.out.println("SecondsToExpire :: "+secondsToExpire);
            if (secondsToExpire > 0) {
                valueOps.set(redisKey, savedBooking, Duration.ofSeconds(secondsToExpire));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();  // You can log this properly using a logger
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return savedBooking;
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking getBookingFromCache(Long bookingId) {
        String redisKey = "booking:" + bookingId;
        Object cached = redisTemplate.opsForValue().get(redisKey);
        System.out.println("RedisKey searched " +redisKey);
        if(cached == null) {
            return null;
        }
        return objectMapper.convertValue(cached, Booking.class);
    }

}

