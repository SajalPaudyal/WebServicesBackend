package com.miage.realestate.service.impl;

import com.miage.realestate.dto.PropertyDto;
import com.miage.realestate.entity.Property;
import com.miage.realestate.mapper.PropertyMapper;
import com.miage.realestate.repository.PropertyRepository;
import com.miage.realestate.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<PropertyDto> getAllProperty(){
        List<Property> properties = propertyRepository.findAll();
        return properties.stream().map(PropertyMapper::mapToPropertyDto).collect(Collectors.toList());
    }

    public PropertyDto updateProperty(Long id, PropertyDto propertyDto){
        Property existingProperty = propertyRepository.findById(id).orElseThrow(NullPointerException::new);
        existingProperty.setAddress(propertyDto.getAddress());
        existingProperty.setDescription(propertyDto.getDescription());
        existingProperty.setLatitude(propertyDto.getLatitude());
        existingProperty.setLongitude(propertyDto.getLongitude());
        existingProperty.setPrice(propertyDto.getPrice());
        existingProperty.setNumberOfBedrooms(propertyDto.getNumberOfBedrooms());
        existingProperty.setNumberOfBathrooms(propertyDto.getNumberOfBathrooms());
        existingProperty.setContactPhone(propertyDto.getContactPhone());
        existingProperty.setContactEmail(propertyDto.getContactEmail());
        existingProperty.setLatitude(propertyDto.getLatitude());
        existingProperty.setLongitude(propertyDto.getLongitude());
        existingProperty.setImageUrl(propertyDto.getImageUrl());
        existingProperty.setIsForRent(propertyDto.getIsForRent());

        propertyRepository.save(existingProperty);
        return PropertyMapper.mapToPropertyDto(existingProperty);
    }

    public PropertyDto deleteById(Long id){
        Property existingProperty = propertyRepository.findById(id).orElseThrow(NullPointerException::new);
        propertyRepository.deleteById(id);
        return PropertyMapper.mapToPropertyDto(existingProperty);
    }

    public PropertyDto getPropertyById(Long id){
        Property existingProperty  =  propertyRepository.findById(id).orElseThrow(NullPointerException::new);
        return PropertyMapper.mapToPropertyDto(existingProperty);
    }

}
