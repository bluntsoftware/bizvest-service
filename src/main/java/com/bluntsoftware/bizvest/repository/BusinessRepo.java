package com.bluntsoftware.bizvest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bluntsoftware.bizvest.model.Business;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepo extends MongoRepository<Business, String> {
}