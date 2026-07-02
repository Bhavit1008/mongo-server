package com.backend.server.repository;

import com.backend.server.model.CatalogueItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogueRepository extends MongoRepository<CatalogueItem, String> {
    List<CatalogueItem> findByMaterial(String material);
    List<CatalogueItem> findByOrigin(String origin);
    Optional<CatalogueItem> findByItemCode(String itemCode);
}
