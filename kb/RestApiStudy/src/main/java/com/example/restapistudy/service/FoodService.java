package com.example.restapistudy.service;

import com.example.restapistudy.domain.Food;
import com.example.restapistudy.dto.FoodDto;
import com.example.restapistudy.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*사용자의 요청을 수행한다.
* Comtroller에서 요청을 받아서 Dto를 Food로 변환해 Repository의 메소드를 호출하거나,
* Repository에서 조회한 객체를 Dto로 바꿔서 다시 Controller에 전달해준다.*/
@Service
public class FoodService {
    private FoodRepository foodRepository; // FoodService는 FoodRepository를 이용하여 음식 데이터를 다루는 클래스이다.


    public FoodService(FoodRepository foodRepository) { // 생성자 FoodService클래스에서는 FoodRepository의 객체를 매개변수foodRepository로 받는다.
        this.foodRepository = foodRepository; //매개변수에 전달된 FoodREpository의 객체를 저장한다.
    }

    //음식 정보를 저장한다.
    public void saveFood(FoodDto foodDto) {
        Food food = foodDto.toEntity(); // FoodDto를 food entity로 바꾸어 준다.
        // 클라이언트 -> 서버 Dto형식으로 데이터가 전달되기 때문에 entity로 바꿔서 데이터 베이스에 저장해 주어야한다.
        foodRepository.save(food); // entity 값을 저장하기
        }

    // 해당하는 id로 음식을 찾는다.
    public FoodDto findFoodByID(Long id) {
        Food food = foodRepository.findById(id); // FoodRepository를 통해 id로 Food객체를 찾아서 food에 저장한다.

        /* 이때 return되는 food 객체는 데이터베이스와 직접 매핑된 entity이기때문에 Dto로 바꿔준다.
        컨트롤러 -> 서비스 , 서비스 -> repository 에서 데이터를 전달할 때는 Dto로 전달한다. */
        return FoodDto.builder()
                .id(food.getId())
                .menu(food.getMenu())
                .cookingTime(food.getCookingTime())
                .price(food.getPrice())
                .build(); // Dto로 바뀐 값들로 새로운 FoodDto객체 만들기.
    }

    // 모든 음식 리스트를 조회하기.
    public List<FoodDto> findAllFood() {
        return foodRepository.findAll() // FoodRepository를 통해서 모든 Food객체를 조회한다.
                .stream() //Stream으로 변환한다.
                //여기서는 list를 반환해야 하니까 forEach말고 .map써야 하는 듯
                .map(food -> { // Food의 객체를
                    return FoodDto.builder() //FoodDto로 바꿔준다.
                            .id(food.getId())
                            .menu(food.getMenu())
                            .cookingTime(food.getCookingTime())
                            .price(food.getPrice())
                            .build(); //새로운 FoodDto객체를 만든다.
                })
                .toList(); //리스트로 바꿔준다.

    }

    //특정 id의 값을 수정한다.
    public void updateFoodByID(Long id, FoodDto foodDto) {
        Food food = foodDto.toEntity(); //FoodDto를 Food entity로 바꾸어준다.
        food.setId(id); //수정할 Food객체의 id를 설정해준다.

        foodRepository.updateById(id, food); // Foodrepository를 통해서 해당 id의 Food객체를 수정한다.
    }

    // 특정 id에 해당하는 값을 삭제한다.
    public void deleteFoodByID(Long id) {
        foodRepository.deleteById(id); //Foodrepository를 통해서 해당 id의 Food객체를 삭제한다.
    }




}

