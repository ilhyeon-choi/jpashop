package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // 스프링과 관련된 것을 테스트한다고 JUnit에 알려줌
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional // java에서 제공한는 것과 스프링에서 제공하는게 있는데 이미 스프링을 사용하고 있어서
    // 스프링 종속적이고 쓸 수 있는 옵션도 많아서 스프링 어노테이션을 사용하는 것을 권장함
    // @Transactional이 Test case에 있으면 Test가 끝나고 나서 Rollback을 한다. 따라서 실제 DB에는 적용이 안된다.
    @Rollback(false) // 그래서 Rollback 어노테이션에 false를 주면 정상적으로 DB에 적용이 된다.
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    }
}