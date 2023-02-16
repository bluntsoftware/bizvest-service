package com.bluntsoftware.bizvest.service;

import com.bluntsoftware.bizvest.model.Business;
import com.bluntsoftware.bizvest.repository.BusinessRepo;
import com.bluntsoftware.bizvest.shared.domain.Registrar;
import com.bluntsoftware.bizvest.shared.service.RegistryService;
import com.bluntsoftware.bizvest.tenant.TenantResolver;
import com.mongodb.client.MongoIterable;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.OptionalInt;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class BusinessService{

  private final BusinessRepo repo;
  private final RegistryService registryService;

  public BusinessService(BusinessRepo repo, RegistryService registryService) {
    this.repo = repo;
    this.registryService = registryService;
  }

  public  Business save(Business item) {

    if(item.getId() != null){
      register(item.getId());
    }
    return repo.save(item);
  }

  public void deleteById(String id) {
      repo.deleteById(id);
  }

  public Optional<Business> findById(String id) {
    return repo.findById(id);
  }

  public Iterable<Business> findAll() {
    return repo.findAll();
  }

  public Page<Business> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }

  public void register(String id){
    repo.findById(id).ifPresent(b->{
      registryService.save(Registrar.builder().active(true)
              .id(b.getId())
              .type("business")
              .tenantId(TenantResolver.resolve())
              .company(b.getName())
              .build());
    });
  }

  public Optional<Business> showById(String id) {
    return Optional.empty();
  }

  public Optional<Business> hideById(String id) {
    return Optional.empty();
  }

}
