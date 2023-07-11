package likelion.springbootbbaco.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String name;
    public static String hello;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //그쪽 클래스에 member이라는 이름으로 저장되어있음
    private List<Order> orderList = new ArrayList<>(); //어떤놈으로 할거다를 정의 (쓸 친구는 ArrayList)

    public static Member createMember(String name, Address address){ //초기화하는 변수가 적어서 가독성이 좋아보이는 것. 필드값이 많을 때는 builduppatten 쓰세요
        Member member = new Member(); //interface에도 적용 가능. 어떻게 불러오는거지 다른 화면에서??????
        member.name = name;
        member.address = address;
        return member;
    }

    private String city;
    private String state;
    private String street;
    private String zipcode;
}
