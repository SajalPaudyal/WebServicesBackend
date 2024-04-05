package com.miage.realestate.service;

import com.miage.realestate.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto createProperty(PropertyDto propertyDto);

    List<PropertyDto> getAllProperty();

    PropertyDto updateProperty(Long PropertyId, PropertyDto propertyDto);
}

