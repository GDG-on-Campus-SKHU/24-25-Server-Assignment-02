package com.example.restapi.repoistory;

import com.example.restapi.domain.Food;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryFoodRepository implements FoodRepository {
    private static Map<Long, Food> store = new HashMap<>();

    @Override
    public void save(Food food) { //입력 받은 id로 음식 저장
        store.put(food.getId(), food);
    }

    @Override
    public Food findById(Long id) { //id(key)로 음식 찾기
        return store.get(id);
    }

    @Override
    public List<Food> findAll() { // 전체 리스트 찾기 (count 내림차순)
        return store.values().
                            stream().sorted(Comparator.comparing(Food::getCount).reversed()).toList();
    }

    @Override
    public void updateById(Long id, Food food) { // 새로운 내용으로 초기화
        store.put(id, food);
    }

    @Override
    public void deleteById(Long id) { //id(key)로 노래 삭제
        store.remove(id);
    }
}
