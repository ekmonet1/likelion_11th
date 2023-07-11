package likelion.springbootbbaco.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String name;
    private Integer price;
    private Integer stock;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItemList = new ArrayList<>();

    //bussiness logic
    //재고추가와 손실
    public void addStock(int quantity)
    {
        this.stock += quantity; //this.stock->객체를 불러오는 것
    }
    public void removeStock(int quantity)
    {
        int restStock = this.stock - quantity;
        if(restStock<0)
        {
            throw new IllegalStateException("need more stock");
        }
        this.stock = restStock;
    }
}
