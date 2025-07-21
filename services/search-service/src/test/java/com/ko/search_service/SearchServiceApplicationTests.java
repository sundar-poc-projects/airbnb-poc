package com.ko.search_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.elasticsearch.uris=http://localhost:9200",
		"spring.kafka.bootstrap-servers=localhost:9093"
})
class SearchServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
