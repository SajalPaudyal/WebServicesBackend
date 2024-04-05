package com.miage.realestate.controller;

import com.miage.realestate.dto.PropertyDto;
import com.miage.realestate.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PropertyController{
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<PropertyDto> createEmployee(@RequestBody PropertyDto propertyDto){
        PropertyDto savedProperty = propertyService.createProperty(propertyDto);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAllProperties(){
        List<PropertyDto> allProperties = propertyService.getAllProperty();
        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }




}