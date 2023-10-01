package com.backend.server.repository;

import com.backend.server.model.CompanyDetails;

public interface CompanyRepository  extends org.springframework.data.mongodb.repository.MongoRepository<CompanyDetails,String>{
}
