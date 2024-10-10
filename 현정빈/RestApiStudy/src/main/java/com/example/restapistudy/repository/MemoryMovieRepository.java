package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMovieRepository implements MovieRepository
{ //인터페이스 구현
    private static Map<Long, Movie> review = new HashMap<>(); //map 이용하여 키(id)와 값(Movie 객체) 구조의 review 생성

    //주어진 Movie 객체를 review에 저장하는 메서드
    @Override
    public void save(Movie movie)
    {
        review.put(movie.getId(),movie); //hashmap review에 키 movie의 id와 값으로 movie 객체 저장
    }

    //id로 조회하고 review에 있는 Movie 객체 반환
    @Override
    public Movie findById(Long id)
    {
        return review.get(id);
    }

    //메모리 저장소에 저장된 모든 Movie 객체를 리스트 형태로 반환
    @Override
    public List<Movie> findAll()
    {
        return review.values()
                .stream()
                .toList();
    }

    //주어진 id에 해당하는 Movie 객체를 새로운 객체로 대체
    @Override 
    public void updateById(Long id, Movie movie)
    {
        review.put(id, movie);
    }

    //주어진 id에 해당하는 Movie 객체를 review에서 삭제
    @Override 
    public void deleteById(Long id)
    {
        review.remove(id);
    }
}
