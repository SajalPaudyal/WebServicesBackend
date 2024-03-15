package com.miage.realestate.models;

import lombok.Data;

import java.util.List;

@Data
public class Property {
    private Long id;
    private String address;
    private String type;
    private double price;
    private String description;
    private Integer bedrooms;
    private Integer bathrooms;
    private double area;
    private List<String> photos;
    private List<String> amenities;
    private Boolean availability;
}

