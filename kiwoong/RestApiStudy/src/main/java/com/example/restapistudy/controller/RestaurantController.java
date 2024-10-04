package com.example.restapistudy.controller;

import com.example.restapistudy.dto.RestaurantDto;
import com.example.restapistudy.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    //생성자 주입
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("restaurant")
    public void save(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.saveRestaurant(restaurantDto);
    }

    @GetMapping("restaurant/{id}")
    public RestaurantDto findRestaurantById(@PathVariable Long id) {
        return restaurantService.findRestaurantById(id);
    }

    @GetMapping("restaurant/list")
    public List<RestaurantDto> findAllRestaurant() {
        return restaurantService.findAllRestaurant();
    }

    @PatchMapping("restaurant/{id}")
    public void updateRestaurantById(@PathVariable Long id, @RequestBody RestaurantDto restaurantDto) {
        restaurantService.updateRestaurantById(id, restaurantDto);
    }

    @DeleteMapping("restaurant/{id}")
    public void deleteRestaurantById(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
    }
}