package com.example.restapistudy.dto;

import com.example.restapistudy.domain.Restaurant;
import lombok.Builder;
import lombok.Data;

@Data
public class RestaurantDto {
    private Long id;
    private String name;
    private String location;

    @Builder
    public RestaurantDto(Long id, String name, String location){
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Restaurant toEntity(){
        return Restaurant.builder()
                .id(id)
                .name(name)
                .location(location)
                .build();
    }
}

