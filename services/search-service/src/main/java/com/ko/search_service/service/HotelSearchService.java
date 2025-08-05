package com.ko.search_service.service;


import java.util.ArrayList;
import java.util.List;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.ko.search_service.entity.Hotel;
import com.ko.search_service.repository.HotelRepository;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class HotelSearchService {

    private final HotelRepository hotelRepository;

    private final ElasticsearchClient elasticsearchClient;

    public HotelSearchService(HotelRepository hotelRepository, ElasticsearchClient elasticsearchClient) {
        this.hotelRepository = hotelRepository;
        this.elasticsearchClient = elasticsearchClient;
    }

    public List<Hotel> searchByLocation(String location) {
        try {
            SearchResponse<Hotel> response = elasticsearchClient.search(s -> s
                            .index("hotels")
                            .query(q -> q
                                    .multiMatch(m -> m
                                            .fields("location.city", "location.district", "location.state", "location.street")
                                            .query(location)
                                    )
                            ),
                    Hotel.class
            );

            return response.hits().hits().stream()
                    .map(Hit::source)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Failed to search hotels by location", e);
        }
    }


    public List<Hotel> findAll() {
        Iterable<Hotel> iterable = hotelRepository.findAll();
        List<Hotel> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}
