package com.example.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/* Food 도메인 클래스 : DB컬럼과 같은 속성의 클래스를 만든다.
* 객체를 만들었다. 실제 데이터베이스에서 관리된다.
* Dto로 변환되거나 Service에서 사용된다.*/
@Getter
@Setter
public class Food {
    //변수 선언
    private Long id; //조회할 food 번호
    private String menu; //메뉴이름
    private Long cookingTime; //조리하는데 걸리는시간
    private Long price; //음식 가격

    @Builder
    public Food (Long id, String menu, Long cookingTime, Long price) { //생성자
        //변수 초기화
        this.id = id; // 클래스에서 만든 변수에 매개변수로 받은 id를 준다.
        this.menu = menu; // 클래스에서 만든 변수에 매개변수로 받은 menu를 준다.
        this.cookingTime = cookingTime; // 클래스에서 만든 변수에 매개변수로 받은 cookingTime을 준다.
        this.price = price; // 클래스에서 만든 변수에 매개변수로 받은 price를 준다.

    }

    private void initId(Long id) { this. id = id;} //음식번호를 초기화하는 메소드


}

