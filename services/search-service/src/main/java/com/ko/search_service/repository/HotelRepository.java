package com.ko.search_service.repository;

import com.ko.search_service.entity.Hotel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends ElasticsearchRepository<Hotel, Long> {
    List<Hotel> findByLocation(String location);
}