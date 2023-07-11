package likelion.springbootBaco.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

/*
* @Entity : DB 테이블에 대응하는 하나의 클래스
* @Getter : xxx필드에 선언하면 getxxx() 메소드를 자동으로 생성해준다.
* @Setter : setxxx()메소드를 자동으로 생성해주고, 클래스 레벨에 선언할 경우 모든 필드에 접근자와 설정자가 자동으로 생성된다.
* @NoArgsConstructor : 파라미터가 없는 모든 생성자를 기본 생성자로 만든다.
* */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {
    /*
    * @Id : PK를 DB와 매칭함을 정의한다.
    * @GeneratedValue : PK를 자동 생성한다.
    * */
    @Id @GeneratedValue
    private Long id;

    /*
    * @OneToMany(mappeBy = "item")
    * OrderItem과 1:N 연관관계로 맵핑된다.
    * item이 관계의 주인이자 1인 쪽
    * OrderItem에 brand, name, price, stock를 입력받아 배열로 넣는다.
    * */

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItem = new ArrayList<>();

    private String brand;
    private String name;
    private Integer price;
    private Integer stock;

    /**
     * 비즈니스 로직
     * ?? 이거 맞아?
     * entity Class에 필드값 변경을 넣어서
     * 도메인이 객체지향적으로 도메인을 제어한다.
     */

    /*
    * stock에 quantity만큼 수량을 증가시킨다.
    * */
    @Comment("재고 추가")
    public void addStock(int quantity) {
        this.stock += quantity;
    }

    /*
    * restStock만큼 stockQuantity가 남아있을 경우 수량을 감소시킨다.
    * */
    @Comment("재고 감소")
    public void removeStock(int stockQuantity) {
        int restStock = this.stock - stockQuantity;
        if (restStock < 0) {
            throw new IllegalStateException("need more stock");
        }
        this.stock = restStock;
    }
}
