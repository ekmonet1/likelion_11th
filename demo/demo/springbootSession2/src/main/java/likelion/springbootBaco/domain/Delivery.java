package likelion.springbootBaco.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static likelion.springbootBaco.domain.Delivery.DeliveryStatus.ESTABLISHED;
import static lombok.AccessLevel.PROTECTED;

/*
* @Entity
* DB 테이블에 대응하는 하나의 클래스
* @Entity가 붙은 클래스는 JPA가 관리하고, JPA를 사용해서 매핑할 클래스는 @Entity를 꼭 붙여야 매핑할 수 있다.
* */
@Entity
/*
* @NoArgsConstructor(access = PROTECTED)
* 파라미터가 없는 모든 생성자를 PROTECTED 상태인 기본 생성자로 만든다.*/
@NoArgsConstructor(access = PROTECTED)
/*
* @Getter
* private 변수에 접근하기 위해 사용하는 메서드
* 캡슐화 방식으로, 인스턴스나 클래스 변수의 값을 호출하는 메소드이다.
* */
@Getter
public class Delivery {
    /*
    * @Id
    * PK를 DB와 매칭함을 정의한다.
    * 맵핑할 정보를 식별할 정보로 활용되어, @Entity 객체의 식별자로 사용할 필드에 적용한다.
    *
    * @GenerateValue
    * @Id의 생성 전략을 정의하기 위해 사용한다.
    * */
    @Id @GeneratedValue
    private Long id;
    /*
    * @OneToOne(mappedBy = "delivery" )
    * 주 테이블과 대상 테이블이 일대일로 매핑된다.
    * 주 테이블과 대상 테이블 모두 외래 키를 가질 수 있다.
    * mappedBy 속성을 통해 delivery가 연관관계의 주인임을 지정한다.
    * 따라서 delivery는 해당 속성을 갖지 않는다(?)
    * */

    @OneToOne(mappedBy = "delivery")
    private Order order;

    /*
    * @Enumerated
    * OrderStatus에 ORDERED, CANCELED라는 enum이 생겼을 때 deliveryStatus 속성에 문자열 값을 세팅하면 DB에 순차적으로 저장된다.
    * */

    @Enumerated(STRING)
    private DeliveryStatus deliveryStatus;

    /*
    * 밑의 delivery 객체를 받기 위해 선언하는 객체들
    * */

    private String city;
    private String state;
    private String street;
    private String zipcode;

    /*
    * Delivery 객체 order, city, state, street, zipcode를 생성한다.
    * */

    public static Delivery createDelivery(Order order, String city, String state, String street, String zipcode) {
        Delivery delivery = new Delivery();
        delivery.order = order;
        delivery.deliveryStatus = ESTABLISHED;
        delivery.city = city;
        delivery.state = state;
        delivery.street = street;
        delivery.zipcode = zipcode;
        return delivery;
    }
    /*
    * ESTABLISHED, PROGRESS, DONE의 차례로 DeliveryStatus에 저장된다.
    * */
    public enum DeliveryStatus {
        ESTABLISHED, PROGRESS, DONE
    }
}
