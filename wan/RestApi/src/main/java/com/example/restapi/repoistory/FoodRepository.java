package com.example.restapi.repoistory;

import com.example.restapi.domain.Food;

import java.util.List;

public interface FoodRepository {

    void save (Food food);

    Food findById(Long id);

    List<Food> findAll();

    void updateById(Long id, Food food);

    void deleteById(Long id);

}