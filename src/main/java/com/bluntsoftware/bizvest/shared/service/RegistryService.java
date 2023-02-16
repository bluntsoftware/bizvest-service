package com.bluntsoftware.bizvest.shared.service;

import com.bluntsoftware.bizvest.shared.domain.Registrar;
import com.bluntsoftware.bizvest.shared.repository.RegistryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
public class RegistryService {

    private final RegistryRepo repo;

    public RegistryService(RegistryRepo repo) {
        this.repo = repo;
    }

    public Registrar save(Registrar registrar){
        return repo.save(registrar);
    }

    public Page<Registrar> search(String term, Pageable pageable) {
        log.info("create a filter in repo for search term {}",term);
        return repo.findAll(pageable);
    }

    public Optional<Registrar> findById(String id) {
        return repo.findById(id);
    }
}
