package com.example.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private Long id;
    private String name;
    private Long number;
    private String major;
    private Long grade;

    @Builder
    public Student(Long id, String name, Long number, String major, Long grade){
        this.id = id;
        this.name = name;
        this.major = major;
        this.number = number;
        this.grade = grade;
    }

    public void initId(Long id) { this.id = id;} // id 주입
}
