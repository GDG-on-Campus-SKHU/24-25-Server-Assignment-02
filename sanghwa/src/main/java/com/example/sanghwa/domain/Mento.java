package com.example.sanghwa.domain;

import lombok.Builder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mento {
    private Long id;
    private String name;
    private String job;

    @Builder
    public Mento(Long id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }
}
