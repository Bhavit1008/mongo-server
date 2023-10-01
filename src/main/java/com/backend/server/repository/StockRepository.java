package com.backend.server.repository;

import com.backend.server.model.CompanyDetails;
import com.backend.server.model.Stock;

public interface StockRepository  extends org.springframework.data.mongodb.repository.MongoRepository<Stock,String>{
}