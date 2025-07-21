package com.ko.search_service.repository;

import com.ko.search_service.entity.HotelDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends ElasticsearchRepository<HotelDocument, Long> {
    List<HotelDocument> findByLocation(String location);
}
