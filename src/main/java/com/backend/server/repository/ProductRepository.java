package com.backend.server.repository;

import org.springframework.stereotype.Repository;

import com.backend.server.model.Block;
import com.backend.server.model.Product;

@Repository
public interface ProductRepository extends org.springframework.data.mongodb.repository.MongoRepository<Product,String> {

}
