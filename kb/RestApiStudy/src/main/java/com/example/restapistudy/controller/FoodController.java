package com.example.restapistudy.controller;


import com.example.restapistudy.dto.FoodDto;
import com.example.restapistudy.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*클라이언트로부터 HTTP요청을 받는다.
* FoodService를 호출해서, FoodDto 객체를 Service에 전달하고 Service로 결과 받아서 클라이언트에 응답해준다.*/
@RestController
public class FoodController {
    private FoodService foodService; //foodService에 FooService객체를저장해준다.

    //생성자
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // 음식 저장을 요청
    @PostMapping("food") // HTTP POST요청을 처리한다.URL 경로는 "food"
    public void save(@RequestBody FoodDto foodDto) { //@RequestBody : 본문요청에 담긴 FoodDto객체를 foodDto로 받는다. 보통은 post사용
        foodService.saveFood(foodDto); //foodService의 saveFood메소드로 FoodDto정보를 저장한다.
    }

    // 특정 id에 해당하는 음식을 조회하는 요청
    @GetMapping("food/{id}") //HTTP Get요청을 받으며 경로는 "food/{id}"
    public FoodDto findFoodById(@PathVariable long id) { // @PathVariable : url경로에 포함된 변수(id)를 파라미터로 사용한다. Get사용
        /*해당 id의 음식을 조회해서 FoodDto로 반환한다.
         FoodService의 findFoodById 메서드를 호출해서 음식 정보를 조회한다. */
        return foodService.findFoodByID(id);
    }

    //모든 음식을 조회하는 요청
    @GetMapping("food/list") // HTTP GET요청을 받았고 URL경로는 "food/list"
    public List<FoodDto> findAllFood() { // 리스트로 바꿔준다.
        return foodService.findAllFood(); // FoodService의 findAllFood()로 모든 음식 데이터를 조회하고 return한다.
    }

    // 특정 id의 음식을 수정하는 요청
    @PatchMapping("food/{id}") // HTTP Patch요청을 받고, URL경로는 "food/{id}"이다.
    public void updateFoodById(@PathVariable long id, @RequestBody FoodDto foodDto) {
        foodService.updateFoodByID(id, foodDto); //FoodService의 updateFoodById()로 해당 id의 FoodDto를 수정한다.
    }

    // 특정 id의 음식을 삭제하는 요청
    @DeleteMapping("food/{id}") //HTTP Delete요청, URL경로는 "food/{id}"
    public void deleteFoodById(@PathVariable long id) {
        foodService.deleteFoodByID(id); //FoodService의 deleteFoodById()로 특정 id의 음식 정보를 삭제한다.
    }
}
