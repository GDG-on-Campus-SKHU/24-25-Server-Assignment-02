package com.example.restapi.service;

import com.example.restapi.domain.Food;
import com.example.restapi.dto.FoodDto;
import com.example.restapi.repoistory.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private  final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) { //생성자
        this.foodRepository = foodRepository;
    }

    public void saveFood(FoodDto foodDto){ //음식 정보 저장 메서드
        Food food = foodDto.toEntity();
        foodRepository.save(food);
    }

    public FoodDto findFoodById(long id){ //음식 찾기 메서드
        Food food = foodRepository.findById(id);

        return FoodDto.builder()
                .id(food.getId())
                .name(food.getName())
                .gobbegi(food.isGobbegi())
                .count(food.getCount())
                .build();
    }
    public List<FoodDto> findAllFood(){ // 음식 리스트 찾기 메서드
        return foodRepository.findAll()
                .stream()
                .map(food -> {
                    return FoodDto.builder()
                            .id(food.getId())
                            .name(food.getName())
                            .gobbegi(food.isGobbegi())
                            .count(food.getCount())
                            .build();
                })
                .toList();
    }
    public void updateFoodById(Long id, FoodDto foodDto){ //음식 업데이트 메서드
        Food food =  foodDto.toEntity();
        food.initId(id);

        foodRepository.updateById(id, food);
    }
    public void deleteFoodById(Long id){ //음식 삭제 메서드
        foodRepository.deleteById(id);
    }
}
