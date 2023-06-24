package com.backend.server.repository;

import com.backend.server.model.Order;

public interface MongoRepository extends org.springframework.data.mongodb.repository.MongoRepository<Order,String> {
}
