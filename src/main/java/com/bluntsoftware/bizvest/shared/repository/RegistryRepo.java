package com.bluntsoftware.bizvest.shared.repository;

import com.bluntsoftware.bizvest.shared.domain.Registrar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryRepo extends MongoRepository<Registrar, String> {

}
