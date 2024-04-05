package com.miage.realestate.mapper;

import com.miage.realestate.dto.PropertyDto;
import com.miage.realestate.entity.Property;


public class PropertyMapper {

    public static PropertyDto mapToPropertyDto(Property property){
        return new PropertyDto(
                property.getId(),
                property.getAddress(),
                property.getPrice(),
                property.getNumberOfBathrooms(),
                property.getNumberOfBedrooms(),
                property.getLatitude(),
                property.getLongitude(),
                property.getContactPhone(),
                property.getContactEmail(),
                property.getDescription()
        );
    }

    public static Property mapToProperty(PropertyDto propertyDto){
        return new Property(
                propertyDto.getId(),
                propertyDto.getAddress(),
                propertyDto.getPrice(),
                propertyDto.getNumberOfBathrooms(),
                propertyDto.getNumberOfBedrooms(),
                propertyDto.getLatitude(),
                propertyDto.getLongitude(),
                propertyDto.getContactPhone(),
                propertyDto.getContactEmail(),
                propertyDto.getDescription()
                );
    }
}
