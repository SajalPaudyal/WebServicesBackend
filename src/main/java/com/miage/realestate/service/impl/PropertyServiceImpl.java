package com.miage.realestate.service.impl;

import com.miage.realestate.dto.PropertyDto;
import com.miage.realestate.entity.Property;
import com.miage.realestate.mapper.PropertyMapper;
import com.miage.realestate.repository.PropertyRepository;
import com.miage.realestate.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    PropertyRepository propertyRepository;

    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {
        Property property = PropertyMapper.mapToProperty(propertyDto);
        Property savedProperty = propertyRepository.save(property);
        return PropertyMapper.mapToPropertyDto(savedProperty);
    }
}
