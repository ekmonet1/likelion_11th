package likelion.springbootBaco.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* @Embeddable
* city, state,street,zipcode라는 주소를 표현하는 필드를 Address라는 하나의 객체로 묶어주는 역할
* */
@Embeddable
/*
* @Data
* 모든 필드를 대상으로 접근자와 설정다가 자동으로 생성되고, 재사용 가능한 코드를 생성한다.
* @Setter과 @Getter 둘 다 쓰고 싶을 때 사용
* */
@Data
/*
* @AllArgsConstructor
* 모든 필드값을 파라미트로 받는 생성자를 만들어준다.
* */
@AllArgsConstructor
/*
* 파라미터가 없는 기본 생성자를 생성해준다.
* */
@NoArgsConstructor
public class Address {
    /*
    * city, state, street, zipcode 필드 생성*/
    private String city;
    private String state;
    private String street;
    private String zipcode;
}
