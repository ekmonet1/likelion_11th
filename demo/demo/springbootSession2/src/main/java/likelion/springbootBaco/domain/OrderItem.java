package likelion.springbootBaco.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    /*
    * OrderItem : Order = N : 1
    * */

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    /*
    * @ManyToOne
    * @JoinColumn(name = "item_id")
    * 도메인의 Item @OneToMany 반대버전
    * item과 N:1 연관관계를 맵핑한다. OrderItem쪽이 N.
    * */
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer price;
    private Integer count;

    /**
     * 스태틱 팩토리 메서드
     * item, orderPrice, orderCount를 받아서 OrderItem으로 묶어 보관한다.
     */
    public static OrderItem createOrderItem(Item item, int orderPrice, int orderCount) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.price = orderPrice;
        orderItem.count = orderCount;
        // 연관관계 편의 메서드
        //orderCount만큼 재고를 감소시키고 남은 아이템 개수를 반환한다.
        item.removeStock(orderCount);
        return orderItem;
    }

    /*
    * order 진행할 때 order과 item 집어넣기
    * */

    public void setOrder(Order order) {
        this.order = order;
        order.getOrderItemList().add(this);
    }

    public void setItem(Item item) {
        this.item = item;
        item.getOrderItem().add(this);
    }

    /**
     * 비즈니스 로직
     * 수량*가격=total을 TotalPrice에 전달한다.
     * cancel한 만큼 수량을 다시 stock에 추가한다.
     */
    public int getTotalPrice() {
        return this.getPrice() * this.getCount();
    }

    public void cancel() {
        this.getItem().addStock(count);
    }
}
