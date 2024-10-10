package com.seun.restapistudy.repository;

import com.seun.restapistudy.domain.Dessert;

import java.util.List;
import java.util.Optional;

public interface DessertRepository {
    void save(Dessert dessert);

    Optional<Dessert> findById(Long id);

    List<Dessert> findAll();

    Optional<List<Dessert>> findByNameOrType(String name, String type);

    boolean existsById(Long id);

    long count(); // 총 디저트 개수

    void deleteAll();

    void update(Dessert dessert);

    void deleteById(Long id);

}
