package com.ko.searchconsumer.repository;

import com.ko.searchconsumer.model.HotelDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends ElasticsearchRepository<HotelDocument, Long> {
}
