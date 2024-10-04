package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 데이터베이스와  상호작용하여 데이터를 직접 다루는 계층
@Repository
public class MemoryMovieRepository implements MovieRepository {
    private static Map<Long, Movie> store = new HashMap<>(); //DB 흉내

    @Override // 입력 받은 id로 영화 저장
    public void save(Movie movie) {
        store.put(movie.getId(), movie);
    }

    @Override // id(key)로 영화 찾기
    public Movie findById(Long id) {
        return store.get(id);
    }

    @Override // 전체 영화 리스트 찾기 (audienceCount 내림차순)
    public List<Movie> findAll() {
        return store.values().stream().sorted(Comparator.comparing(Movie::getAudienceCount).reversed()).toList();
    }

    @Override // 새로운 내용으로 초기화
    public void updateById(Long id, Movie movie) {
        store.put(id, movie);
    }

    @Override // id(key)로 영화 삭제
    public void deleteById(Long id) {
        store.remove(id);
    }
}
