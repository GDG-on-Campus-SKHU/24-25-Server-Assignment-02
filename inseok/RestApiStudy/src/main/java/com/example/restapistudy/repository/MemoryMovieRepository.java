package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMovieRepository implements MovieRepository {
    private static Map<Long, Movie> store = new HashMap<>();

    @Override
    public void save(Movie movie) {
        store.put(movie.getId(), movie);
    }

    @Override
    public Movie findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Movie> findAll() {
        return store.values().stream().sorted(Comparator.comparing(Movie::getId).reversed()).toList();
    }

    @Override
    public void updateById(Long id, Movie movie) {
        store.put(id, movie);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
