package com.example.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Restaurant {
    private Long id; // 식당 번호(추가한 순서)
    private String name; // 식당이름
    private String location; // 지역

    @Builder
    public Restaurant(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    public void initId(Long id){ this.id = id;} // 식당 번호 초기화 메서드
}
