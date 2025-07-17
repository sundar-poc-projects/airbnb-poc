# airbnb-poc


1. Project Structure
airbnb-poc/
├── docker-compose.yml           # Global orchestration
├── kafka/                       # Kafka + Zookeeper
│   └── docker-compose.yml
├── elasticsearch/               # Elasticsearch + Kibana (optional)
│   └── docker-compose.yml
├── services/
│   ├── hotel-service/           # Spring Boot + MySQL
│   ├── search-consumer/         # Spring Boot + Kafka Consumer + Elasticsearch client
│   ├── search-service/          # REST API to query Elasticsearch
│   ├── booking-service/         # Booking + MySQL + Redis
│   └── booking-management/      # Read layer (Redis + MySQL)
├── common-lib/                  # Shared DTOs, Kafka config, utils
└── README.md


2.  Tech Stack Per Service
  | Service            | Tech Stack                             |
| ------------------ | -------------------------------------- |
| hotel-service      | Spring Boot, MySQL, Kafka Producer     |
| search-consumer    | Spring Boot, Kafka Consumer, ES Client |
| search-service     | Spring Boot, Elasticsearch             |
| booking-service    | Spring Boot, MySQL, Redis              |
| booking-management | Spring Boot, Redis, MySQL (read-only)  |

