package com.ko.search_service.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import org.springframework.beans.factory.annotation.Value;

@Configuration
public class ElasticSearchConfig {

    private final String elasticsearchUri;

    public ElasticSearchConfig(@Value("${spring.elasticsearch.uris}") String elasticsearchUri) {
        System.out.println("elasticsearchUri ::: "+elasticsearchUri);
        this.elasticsearchUri = elasticsearchUri;
    }

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RestClient restClient = RestClient.builder(HttpHost.create(elasticsearchUri)).build();

        JacksonJsonpMapper mapper = new JacksonJsonpMapper(objectMapper);
        ElasticsearchTransport transport = new RestClientTransport(restClient, mapper);
        return new ElasticsearchClient(transport);
    }
}


