package likelion.springbootbbaco.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") //table화 할 때 orders로 이름 지정해줘
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id @GeneratedValue //@GeneratedValue 이제부터 말하는 값을 pk로 알아들을거야. 보통 long을 사용한대
    //@Column = db에서는 다른 이름으로 바꿀거야
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public void setMember(Member member) {
        this.member = member;
        member.getOrderList().add(this); //필드값을 한쪽에 설정할 때 반대쪽에도 같이 연결
    }

    public static Order createOrder(Member member, OrderItem... orderItems) { //...은 orderitem의 변수를 여러개 입력할 때 사용. 여러개라서 for문 사용
        Order order = new Order();
        order.setMember(member);
        order.orderDate = LocalDateTime.now();
        order.orderStatus = OrderStatus.ORDERED;
        order.delivery = Delivery.createDelivery(order, //static method로 member의 address를 받아서??????
                member.getAddress().getCity(),
                member.getAddress().getState(),
                member.getAddress().getStreet(),
                member.getAddress().getZipcode());
        for(OrderItem orderItem : orderItems){ //원래 쓰는 방법 말고 orderitems 안에 있는 여러 데이터들을 하나하나 뽑아서 돌리는 것
            order.orderItemList.add(orderItem);
            orderItem.setOrder(order);
        }
        return order;
    }
}