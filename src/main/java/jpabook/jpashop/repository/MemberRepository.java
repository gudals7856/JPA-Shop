package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository  // 컴포넌트 스캔에 의해 자동으로 스프링 빈 등록
@RequiredArgsConstructor
public class MemberRepository {

    @Autowired
    private final EntityManager em;   // 스프링이 엔티티매니저를 만들어서 주입시켜줌

    public void save(Member member) {
        em.persist(member);
    }

    /**
     * 첫번째 인자 : 타입, 두번째 인자 : 기본키
     */
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    /**
     * 첫번째 인자 : JPQL, 두번째 인자 : 반환타입
     */
    // SQL은 테이블 대상으로 쿼리
    // JPQL은 엔티티 객체를 대상으로 쿼리
    public List<Member> findAll() {

        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    /**
     * name 파라미터를 쿼리문의 name부분에 바인딩해서 특정 이름의 회원만 찾음
     */
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}

