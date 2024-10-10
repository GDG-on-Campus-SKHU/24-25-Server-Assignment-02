package com.example.restapistudy.dto;

import com.example.restapistudy.domain.Food;
import lombok.Builder;
import lombok.Data;

/* dto클래스는 도메인과 데이터를 주고 받을 수 있는 클래스, 주고 싶은 거나 받고 싶은 것만 관리가 가능하다.
* 데이터 전송 객체로 클라이언트와 서버 사이의 데이터 전송을 용이하게 해준다.*/
@Data // Getter, Setter 자동 생성
public class FoodDto {
    private Long id; //조회할 food 번호
    private String menu; //메뉴이름
    private Long cookingTime; //조리하는데 걸리는시간
    private Long price; //가격

    @Builder
    public FoodDto (Long id, String menu, Long cookingTime, Long price) { //생성자
        //변수 초기화
        this.id = id; // 클래스에서 선언한 id변수에 매개변수로 받은 값을 넣어준다.
        this.menu = menu; // 클래스에서 선언한 munu변수에 매개변수로 받은 값을 넣어준다.
        this.cookingTime = cookingTime; // 클래스에서 선언한 cookingTime변수에 매개변수로 받은 값을 넣어준다.
        this.price = price; // 클래스에서 선언한 price변수에 매개변수로 받은 값을 넣어준다.
    }

    public Food toEntity() { // FoodDto객체를 Food객체로 바꿔주는 메소드
        return Food.builder() // Food클래스에 있는 builder불러오기
                .id(id) //Dto클래스에서 받은 id 값을 Food클래스에 있는 id에 넣어준다.
                .menu(menu) //Dto클래스에서 받은 menu 값을 Food클래스에 있는 menu에 넣어준다.
                .cookingTime(cookingTime) //Dto클래스에서 받은 cookingTime 값을 Food클래스에 있는 cookingTime에 넣어준다.
                .price(price) //Dto클래스에서 받은 price 값을 Food클래스에 있는 price에 넣어준다.
                .build(); // 새로운 Food객체 만들기
    }


}
