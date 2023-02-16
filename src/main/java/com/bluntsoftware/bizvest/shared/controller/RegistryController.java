package com.bluntsoftware.bizvest.shared.controller;

import com.bluntsoftware.bizvest.dto.BusinessDto;
import com.bluntsoftware.bizvest.mapping.BusinessMapper;
import com.bluntsoftware.bizvest.shared.domain.Registrar;
import com.bluntsoftware.bizvest.shared.service.RegistryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/rest/registry")
public class RegistryController {
    private final RegistryService registryService;

    public RegistryController(RegistryService registryService) {
        this.registryService = registryService;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Registrar> findById(@PathVariable("id") String id ){
        return this.registryService.findById(String.valueOf(id));
    }

    @ResponseBody
    @GetMapping(value = {"/search"}, produces = { "application/json" })
    public Page<Registrar> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                                  @RequestParam(value = "page",  defaultValue = "0") Integer page,
                                  @RequestParam(value = "limit", defaultValue = "50") Integer limit){
        return this.registryService.search(searchTerm, PageRequest.of(page,limit));
    }
}
