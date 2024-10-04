package com.seun.restapistudy.repository;

import com.seun.restapistudy.domain.Dessert;

import java.util.List;

public interface DessertRepository {
    void save(Dessert dessert);

    Dessert findById(Long id);

    List<Dessert> findAll();

    List<Dessert> findByName(String name);

    List<Dessert> findByType(String type);

    boolean existsById(Long id);

    long count(); // 총 디저트 개수

    void deleteAll();

    void update(Dessert dessert);

    void deleteById(Long id);

}
