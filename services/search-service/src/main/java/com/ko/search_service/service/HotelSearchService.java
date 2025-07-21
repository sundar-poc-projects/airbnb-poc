package com.ko.search_service.service;


import java.util.ArrayList;
import java.util.List;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.ko.search_service.entity.HotelDocument;
import com.ko.search_service.repository.HotelRepository;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelSearchService {

    private final HotelRepository hotelRepository;

    private final ElasticsearchClient elasticsearchClient;

    public HotelSearchService(HotelRepository hotelRepository, ElasticsearchClient elasticsearchClient) {
        this.hotelRepository = hotelRepository;
        this.elasticsearchClient = elasticsearchClient;
    }

    public List<HotelDocument> searchByLocation(String location) {
        try {
            SearchResponse<HotelDocument> response = elasticsearchClient.search(s -> s
                            .index("hotels")
                            .query(q -> q
                                    .match(m -> m
                                            .field("location")
                                            .query(location)
                                    )
                            ),
                    HotelDocument.class
            );

            return response.hits().hits().stream()
                    .map(Hit::source)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Failed to search hotels by city", e);
        }
    }


    public List<HotelDocument> findAll() {
        Iterable<HotelDocument> iterable = hotelRepository.findAll();
        List<HotelDocument> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}
