package likelion.springbootBaco.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

/*
* @Entity : DB 테이블에 대응하는 하나의 클래스
* @Table(name = "orders") : DB에서 테이블명을 orders로 하여 order객체를 매핑한다.
* @Getter : 모든 필드를 대상으로 접근자와 설정다가 자동으로 생성
* @NoArgsConstructor(access = PROTECTED) : 파라미터가 없는 모든 생성자를 PROTECTED 상태인 기본 생성자로 만든다.
* */

@Entity
@Table(name = "orders") // 이거 안하면 에러
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Order {
    @Id
    @GeneratedValue
    //@Column = db에서는 다른 이름으로 바꿀거야
    private Long id;

    /*
    * @ManyToOne
    * @JoinColume(name = "member_id")
    * domain의 member에 있는 @OneToMany와 관련된 코드
    * 입력받은 orderList가 many, member가 one이다.
    * */

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    /*
    * @OneToOne
    * @JoinColume(name = "delivery_id")
    * domain의 delivery에 있는 @OneToOne에 있는 코드와 관련됨
    * 속성을 가지고 있는 객체
    * */
    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    /*
    * @OneToMany(mappedBy = "order", cascade = ALL)
    * OrderItem이라는 리스트와 1:N 연관관계이자 order가 주인으로 맵핑된다.
    * 연관된(모든?) 엔티티도 영속상태로 만들기 위해 cascade=ALL 설정
    * */

    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

    private LocalDateTime orderDate;

    /*
    * @Enumerated(EnumType.STRING)
    * 문자열 타입의 orderStatus를 순차적으로 DB에 저장한다.
    * */

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    // 연관관계 편의 메서드
    public void setMember(Member member) {
        //필드값을 한쪽에 설정할 때 반대쪽에도 같이 연결
        this.member = member;
        member.getOrderList().add(this);
    }

    /*
    * 주문시간을 저장하고 상태를 바꾸고 정보 배열을 만들어서 저장하고 order를 리턴한다.
    * */

    public static Order createOrder(Member member, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.orderDate = LocalDateTime.now();
        order.orderStatus = OrderStatus.ORDERED;
        order.delivery = Delivery.createDelivery(order, member.getAddress().getCity(),
                member.getAddress().getState(),
                member.getAddress().getStreet(),
                member.getAddress().getZipcode());
        //원래 쓰는 방법 말고 orderitems 안에 있는 여러 데이터들을 하나하나 뽑아서 돌리는 것
        for (OrderItem orderItem : orderItems) {
            order.orderItemList.add(orderItem);
            orderItem.setOrder(order);
        }
        return order;
    }


    /*
    * 주문 취소할 때 주문 완료가 되어있을 경우 반려함
    * */
    public void cancel() {
        if (delivery.getDeliveryStatus() == Delivery.DeliveryStatus.DONE) {
            throw new IllegalStateException("배송 완료했다 양아치야");
        }
        //주문 완료상태가 아닐 경우 취소를 진행한다.
        this.orderStatus = OrderStatus.CANCELED;
        for (OrderItem orderItem : orderItemList) {
            orderItem.cancel();
        }
    }


    /*
    * 아이템 개수만큼 그 값을 더해서 total을 반환한다.
    * */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItemList) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
