package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    void save(Restaurant restaurant);

    Restaurant findById(Long id);

    List<Restaurant> findAll();

    void updateById(Long id, Restaurant restaurant);

    void deleteById(Long Id);
    }