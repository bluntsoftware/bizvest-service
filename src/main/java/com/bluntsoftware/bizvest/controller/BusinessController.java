package com.bluntsoftware.bizvest.controller;

import com.bluntsoftware.bizvest.model.Business;
import com.bluntsoftware.bizvest.dto.BusinessDto;
import com.bluntsoftware.bizvest.mapping.BusinessMapper;
import com.bluntsoftware.bizvest.service.BusinessService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class BusinessController {

  private final BusinessService service;

  public BusinessController(BusinessService service) {
    this.service = service;
  }

  @PostMapping(value="/business",produces = MediaType.APPLICATION_JSON_VALUE)
  public BusinessDto save(@RequestBody BusinessDto dto){
        return BusinessMapper.MAPPER.businessToBusinessDto(this.service.save(BusinessMapper.MAPPER.businessDtoToBusiness(dto)));
  }

  @GetMapping(value = "/business/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<BusinessDto> findById(@PathVariable("id") String id ){
    return this.service.findById(String.valueOf(id)).map(BusinessMapper.MAPPER::businessToBusinessDto);
  }

  @GetMapping(value = "/business",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<BusinessDto> findAll(){
    return StreamSupport.stream(this.service.findAll().spliterator(),true)
        .map(BusinessMapper.MAPPER::businessToBusinessDto).collect(Collectors.toList());
  }

  @DeleteMapping(value = "/business/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(String.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/business/search"}, produces = { "application/json" })
  public Page<Business> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }

  @GetMapping(value = "/business/{id}/show",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<BusinessDto> showById(@PathVariable("id") String id ){
    return this.service.showById(String.valueOf(id)).map(BusinessMapper.MAPPER::businessToBusinessDto);
  }

  @GetMapping(value = "/business/{id}/hide",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<BusinessDto> hideById(@PathVariable("id") String id ){
    return this.service.hideById(String.valueOf(id)).map(BusinessMapper.MAPPER::businessToBusinessDto);
  }

}
