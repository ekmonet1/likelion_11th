package likelion.springbootbbaco.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable //값을 박아놓는 것
@Data //자잘자잘한 기능을 묶는 건데 보통 getter&setter를 같이 쓰고 싶을 때 주로 사용
@AllArgsConstructor //모든 생성자 자동완성
@NoArgsConstructor //기본 생성자 자동완성
public class Address {
    private String city;
    private String state;
    private String street;
    private String zipcode;
}