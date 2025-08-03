package com.ko.searchconsumer.repository;

import com.ko.searchconsumer.entity.Hotel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends ElasticsearchRepository<Hotel, Long> {
}
