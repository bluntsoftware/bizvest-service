package com.bluntsoftware.bizvest.mapping;

import com.bluntsoftware.bizvest.dto.BusinessDto;
import com.bluntsoftware.bizvest.model.Business;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusinessMapper {
    BusinessMapper MAPPER = Mappers.getMapper( BusinessMapper.class );

    Business businessDtoToBusiness(BusinessDto employeeDto);
    BusinessDto businessToBusinessDto(Business employee);
}
