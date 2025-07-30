package com.ko.booking_service.controller;


import com.ko.booking_service.entity.Booking;
import com.ko.booking_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @GetMapping("/cache/{bookingId}")
    public Booking getBookingFromCache(@PathVariable Long bookingId) {
        return bookingService.getBookingFromCache(bookingId);
    }

}

