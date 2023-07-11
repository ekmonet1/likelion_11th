package likelion.springbootBaco.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;


/*
 * @Entity : DB 테이블에 대응하는 하나의 클래스
 * @Getter : xxx필드에 선언하면 getxxx() 메소드를 자동으로 생성해준다.
 * @NoArgsConstructor : 파라미터가 없는 모든 생성자를 기본 생성자로 만든다.
 */
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {
    /*
    * @Id : PK를 DB와 매칭함을 정의한다.
    * @GeneratedValue : PK를 자동 생성한다.
    * */
    @Id @GeneratedValue
    private Long id;

    private String name;

    /*
    * @OneToMany(mappedBy = "member")
    * Orderlist에 member 하나가 연관되는 1:N 연관관계
    * member가 1이자 주인이다.
    * */

    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();

    /*
    * @Embedded
    * 입력받은 데이터들을 Address라는 객체로 묶기 위해 선언하는 어노테이션
    * */

    @Embedded
    private Address address;

    /*
    * member, name, address를 선언받아 member만 리턴한 후 name이라는 배열을 만든다.
    * Embedded된 Address로 관리한다.
    * */
    public static Member createMember(String name, Address address) {
        Member member = new Member();
        member.name = name;
        member.address = address;
        return member;
    }
}
