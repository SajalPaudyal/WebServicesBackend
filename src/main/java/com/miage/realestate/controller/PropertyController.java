package com.miage.realestate.controller;

import com.miage.realestate.dto.PropertyDto;
import com.miage.realestate.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@AllArgsConstructor
public class PropertyController{
    private PropertyService propertyService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PropertyDto> createEmployee(@RequestBody PropertyDto propertyDto){
        PropertyDto savedProperty = propertyService.createProperty(propertyDto);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAllProperties(){
        List<PropertyDto> allProperties = propertyService.getAllProperty();
        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PropertyDto> updatePropertyById(@PathVariable Long id, @RequestBody PropertyDto propertyDto){
        PropertyDto updatedProperty = propertyService.updateProperty(id,propertyDto );
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<PropertyDto> deletePropertyById(@PathVariable Long id){
        PropertyDto deletedProperty = propertyService.deleteById(id);
        return new ResponseEntity<>(deletedProperty, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable Long id){
        PropertyDto foundProperty = propertyService.getPropertyById(id);
        return new ResponseEntity<>(foundProperty, HttpStatus.FOUND);
    }

}