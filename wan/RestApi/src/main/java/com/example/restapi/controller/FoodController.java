package com.example.restapi.controller;

import com.example.restapi.dto.FoodDto;
import com.example.restapi.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    private FoodService foodService;

    //생성자 주입
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("food")  //음식 저장
    public void save(@RequestBody FoodDto foodDto) {
        foodService.saveFood(foodDto);
    }

    @GetMapping("food/{id}")
    public FoodDto findFoodById(@PathVariable Long id) {
        return foodService.findFoodById(id);
    }

    @GetMapping("food/list") // 음식 리스트 찾기
    public List<FoodDto> findAllFood() {
        return foodService.findAllFood();
    }

    @PatchMapping("food/{id}")
    public void updateFoodById(@PathVariable Long id, @RequestBody FoodDto foodDto) {
        foodService.updateFoodById(id, foodDto);
    }

    @DeleteMapping("food/{id}")
    public void deleteFoodById(@PathVariable Long id) {
        foodService.deleteFoodById(id);
    }













}
