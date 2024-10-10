package com.example.sanghwa.domain;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentee {
    private Long id;
    private String name;
    private String major;

    @Builder
    public Mentee(Long id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }


}
