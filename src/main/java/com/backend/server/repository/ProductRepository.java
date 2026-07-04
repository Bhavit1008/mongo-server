package com.backend.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.backend.server.model.Product;

@Repository
public interface ProductRepository extends org.springframework.data.mongodb.repository.MongoRepository<Product,String> {

    Page<Product> findByCategory(String category, Pageable pageable);

}
