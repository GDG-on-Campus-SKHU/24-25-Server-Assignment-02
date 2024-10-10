package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Food;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*FoodRepository인터페이스를 구현한다.
* Service에서 호출하면 데이터를 저장하고 조회한다.*/
@Repository
public class MemoryFoodRepository implements FoodRepository {
    private static Map<Long, Food> foods = new HashMap<>(); // 데이터 저장소

    @Override
    public void save(Food food) {
        foods.put(food.getId(), food); //id를 받아서 food값 저장하기.
    }

    @Override
    public Food findById(Long id) {
        return foods.get(id); // id를 이용해서 foods에서 Food찾기
    }

    //전체 리스트 찾기
    @Override
    public List<Food> findAll() {
        return foods.values().stream().toList(); //foods에 있는 Food 객체들의 값을 stream으로 바꿔서 list로 return한다.

    }

    //수정하기
    @Override
    public void updateById(Long id, Food food) {
        foods.put(id, food); //해당하는 id의 food값을 수정한다.
    }

    //삭제하기
    @Override
    public void deleteById(Long id) {
        foods.remove(id); //해당하는 id 값을 삭제한다.
    }

}
