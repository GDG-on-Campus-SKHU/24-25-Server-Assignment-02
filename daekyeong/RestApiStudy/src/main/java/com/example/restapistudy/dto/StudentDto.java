package com.example.restapistudy.dto;

import com.example.restapistudy.domain.Student;
import lombok.Builder;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private Long number;
    private String major;
    private Long grade;

    @Builder
    public StudentDto(Long id, String name, Long number, String major, Long grade) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.major = major;
        this.grade = grade;
    }

    public Student toEntity() {
        return Student.builder()
                .id(id)
                .name(name)
                .number(number)
                .major(major)
                .grade(grade)
                .build();
    }
}
