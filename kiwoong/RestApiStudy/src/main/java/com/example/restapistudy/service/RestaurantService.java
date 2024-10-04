package com.example.restapistudy.service;

import com.example.restapistudy.domain.Restaurant;
import com.example.restapistudy.dto.RestaurantDto;
import com.example.restapistudy.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) { // 생성자
        this.restaurantRepository = restaurantRepository;
    }

    public void saveRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantDto.toEntity();

        restaurantRepository.save(restaurant);
    }

    public RestaurantDto findRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);

        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .build();
    }

    public List<RestaurantDto> findAllRestaurant() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurant -> {
                    return RestaurantDto.builder()
                            .id(restaurant.getId())
                            .name(restaurant.getName())
                            .location(restaurant.getLocation())
                            .build();
                })
                .toList();
    }

    public void updateRestaurantById(Long id, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantDto.toEntity();
        restaurant.initId(id);

        restaurantRepository.updateById(id, restaurant);
    }

    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }
}
