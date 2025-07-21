package com.ko.search_service.controller;

import com.ko.search_service.entity.HotelDocument;
import com.ko.search_service.service.HotelSearchService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelSearchController {

    private final HotelSearchService hotelSearchService;

    public HotelSearchController(HotelSearchService hotelSearchService) {
        this.hotelSearchService = hotelSearchService;
    }

    @GetMapping("/location/{location}")
    public List<HotelDocument> searchByCity(@PathVariable String location) {
        return hotelSearchService.searchByLocation(location);
    }

    @GetMapping
    public List<HotelDocument> getAllHotels() {
        List<HotelDocument> all = hotelSearchService.findAll();
        System.out.println(all);
        return all;
    }
}


