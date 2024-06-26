package com.miage.realestate.dto;


import com.miage.realestate.entity.User;
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
    private String contactPhone;
    private String contactEmail;
    private String description;
    private String imageUrl;
    private Boolean isForRent;
    private User user;
}
