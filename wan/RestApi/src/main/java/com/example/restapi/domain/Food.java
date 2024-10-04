package com.example.restapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Food {
    private Long id; //조회할 Food 번호
    private String name; // 음식 이름
    private boolean gobbegi; //곱빼기 유무
    private Long count; //음식을 시킨 횟수

    @Builder
    public Food(Long id, String name, boolean gobbegi, Long count) {
        this.id = id;
        this.name = name;
        this.gobbegi = gobbegi;
        this.count = count;
    }

    public void initId(Long id) {this.id = id;}


}
