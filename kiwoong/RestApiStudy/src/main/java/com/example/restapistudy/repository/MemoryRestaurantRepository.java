package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryRestaurantRepository implements RestaurantRepository{
    private static Map<Long, Restaurant> store = new HashMap<>();

    @Override
    public void save(Restaurant restaurant){
        store.put(restaurant.getId(), restaurant);
    }
    @Override
    public Restaurant findById(Long id){
        return store.get(id);
    }
    @Override
    public List<Restaurant> findAll(){
        return store.values().stream().toList();
    }
    @Override
    public void updateById(Long id, Restaurant restaurant){
        store.put(id, restaurant);
    }
    @Override
    public void deleteById(Long id){
        store.remove(id);
    }
}
