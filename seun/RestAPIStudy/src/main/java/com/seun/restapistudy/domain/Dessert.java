package com.seun.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dessert {
    private Long id;            // 디저트 ID
    private String name;       // 디저트 이름
    private String description; // 디저트 설명
    private Long price;      // 디저트 가격
    private Long calories;   // 디저트 칼로리
    private String type;       // 디저트 종류

    @Builder
    public Dessert(Long id, String name, String description, Long price, Long calories, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.type = type;
    }
}
