package com.example.restapi.dto;


import com.example.restapi.domain.Food;
import lombok.Builder;
import lombok.Data;

@Data
public class FoodDto {
    private Long id;
    private String name;
    private Boolean gobbegi;
    private Long count;

    @Builder
    public FoodDto(Long id, String name, Boolean gobbegi, Long count) {
        this.id = id;
        this.name = name;
        this.gobbegi = gobbegi;
        this.count = count;

    }

    public Food toEntity(){  //DTO 객체를 Food로 변환하는 메서드
        return Food.builder()
                .id(id)
                .name(name)
                .gobbegi(gobbegi)
                .count(count)
                .build();
    }

}
