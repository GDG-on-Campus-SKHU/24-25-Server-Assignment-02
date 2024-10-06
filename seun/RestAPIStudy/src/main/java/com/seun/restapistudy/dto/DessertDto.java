package com.seun.restapistudy.dto;

import com.seun.restapistudy.domain.Dessert;
import lombok.Builder;
import lombok.Data;

@Data
public class DessertDto {
    private Long id;            // 디저트 ID
    private String name;       // 디저트 이름
    private String description; // 디저트 설명
    private Long price;      // 디저트 가격
    private Long calories;   // 디저트 칼로리
    private String type;       // 디저트 종류

    @Builder
    public DessertDto(Long id, String name, String description, Long price, Long calories, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.type = type;
    }

    public Dessert toEntity() {
        return Dessert.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .calories(calories)
                .type(type)
                .build();
    }

}
