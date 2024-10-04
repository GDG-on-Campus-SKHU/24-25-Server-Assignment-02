package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Movie;

import java.util.List;

public interface MovieRepository {
    void save(Movie movie); // 영화 저장

    Movie findById(Long id); // ID로 영화 찾기

    List<Movie> findAll(); // 모든 영화 찾기

    void updateById(Long id, Movie movie); // ID로 영화 업데이트

    void deleteById(Long id); // ID로 영화 삭제
}
