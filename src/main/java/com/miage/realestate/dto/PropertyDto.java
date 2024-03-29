package com.miage.realestate.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private Long id;
    private String address;
    private int price;
    private int numberOfBathrooms;
    private int numberOfBedrooms;
    private Double latitude;
    private Double longitude;
    private String description;
    private String contactEmail;
    private String contactPhone;

}
