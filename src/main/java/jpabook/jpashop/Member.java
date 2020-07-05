package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter // lombok api 활용, 자동으로 getter, setter를 만들어준다. 없으면 직접 만들어야 한다.
public class Member {

    @Id @GeneratedValue // 기본키와 자동생성설정 어노테이션
    private Long id;
    private String username;
}
